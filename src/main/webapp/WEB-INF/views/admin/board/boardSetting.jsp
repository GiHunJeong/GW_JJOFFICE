<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 쩡키
  Date: 2023-12-20
  Time: PM 1:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Content Header (Page header) -->
<div class="content-header">
  <div class="container-fluid">
    <div class="row mb-2">
      <div class="col-sm-6">
        <h1 class="m-0">게시판 관리</h1>
      </div><!-- /.col -->
      <div class="col-sm-6">
        <ol class="breadcrumb float-sm-right">
          <li class="breadcrumb-item"><a id="test" href="javascript:void(0);">Home</a></li>
          <li class="breadcrumb-item active">게시판 관리</li>
        </ol>
      </div><!-- /.col -->
    </div><!-- /.row -->
  </div><!-- /.container-fluid -->
</div>
<!-- /.content-header -->
<section class="content">
  <div class="row">
    <div class="col-md-4">
      <div class="card card-primary">
        <div class="card-header">
          <h3 class="card-title">게시판 트리뷰</h3>
          <div class="card-tools">
            <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
              <i class="fas fa-minus"></i>
            </button>
          </div>
        </div>
        <div class="card-body" style="display: block;">
          <%-- 게시판 트리뷰 --%>
            <ul class="nav nav-pills nav-sidebar nav-child-indent flex-column" data-widget="treeview" role="menu">
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="nav-icon fas fa-folder"></i>
                  <p>
                    게시판
                    <i class="right fas fa-angle-left"></i>
                  </p>
                </a>
                <ul id="menu" class="nav nav-treeview" style="display: none;">

                </ul>
              </li>
            </ul>
          <%-- 게시판 트리뷰 --%>
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->
    </div>
    <div class="col-md-8">
      <div class="card card-secondary">
        <div class="card-header">
          <h3 class="card-title">게시판 추가/삭제</h3>
          <div class="card-tools">
            <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
              <i class="fas fa-minus"></i>
            </button>
          </div>
        </div>
        <div class="card-body">
          <%-- 게시판 추가/삭제 --%>
          <input id="upperFolderSn" class="form-control" type="hidden" placeholder="선택한 상위 폴더 이름"/>
          <input id="upperFolderName" class="form-control" type="text" placeholder="선택한 상위 폴더 이름" readonly/>
          <input id="newFolderName" class="form-control" type="text" placeholder="폴더 이름"/>
          <input id="folderSort" class="form-control" type="text" placeholder="폴더 순서"/>
          <input id="folderUrl" class="form-control" type="text" placeholder="URL"/>
          <button type="button" class="btn btn-block btn-outline-primary" onclick="saveAction();">추가</button>
          <%-- 게시판 추가/삭제 --%>
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->
    </div>
  </div>
</section>
<script>
  menu();
  function menu() {
    let menuList = customAjax.fn_customAjax('/ajax/boardSetting/menuList');
    $.each(menuList.rs, function(i, x) {
      let menu = '';
      if(x.board_folder_dept == '0') {
        if(x.board_folder_child_yn == 'N') {
          menu = `<li class="nav-item"><input class="folderCheck" type="checkbox" value="`+x.board_folder_sn+`"/><a href="#" class="nav-link"><i class="nav-icon fas fa-folder"></i><p>`+x.board_folder_name+ `</p></a>`;
        }else {
          menu = `<li class="nav-item"><input class="folderCheck" type="checkbox" value="`+x.board_folder_sn+`"/><a href="#" class="nav-link"><i class="nav-icon fas fa-folder"></i><p>`+x.board_folder_name+`<i class="right fas fa-angle-left"></i></p></a><ul menu="`+x.board_folder_sn+`" class="nav nav-treeview" style="display: none;"></ul>`;
        }
        $('#menu').append(menu);
      }else if(x.board_folder_dept == '1') {
        if(x.board_folder_child_yn == 'N') {
          menu = `<li class="nav-item"><input class="folderCheck" type="checkbox" value="`+x.board_folder_sn+`"/><a href="#" class="nav-link"><i class="nav-icon fas fa-folder"></i><p>`+x.board_folder_name+ `</p></a>`;
        }else {
          menu = `<li class="nav-item"><input class="folderCheck" type="checkbox" value="`+x.board_folder_sn+`"/><a href="#" class="nav-link"><i class="nav-icon fas fa-folder"></i><p>`+x.board_folder_name+`<i class="right fas fa-angle-left"></i></p></a><ul menu="`+x.board_folder_sn+`" class="nav nav-treeview" style="display: none;"></ul>`;
        }
        $("ul[menu='"+x.board_folder_upper_sn+"']").append(menu);
      }else if(x.board_folder_dept == '2') {
        if(x.board_folder_child_yn == 'N') {
          menu = `<li class="nav-item"><input class="folderCheck" type="checkbox" value="`+x.board_folder_sn+`"/><a href="#" class="nav-link"><i class="nav-icon fas fa-folder"></i><p>`+x.board_folder_name+ `</p></a>`;
        }else {
          menu = `<li class="nav-item"><input class="folderCheck" type="checkbox" value="`+x.board_folder_sn+`"/><a href="#" class="nav-link"><i class="nav-icon fas fa-folder"></i><p>`+x.board_folder_name+`<i class="right fas fa-angle-left"></i></p></a><ul menu="`+x.board_folder_sn+`" class="nav nav-treeview" style="display: none;"></ul>`;
        }
        $("ul[menu='"+x.board_folder_upper_sn+"']").append(menu);
      }else if(x.board_folder_dept == '3') {
        if(x.board_folder_child_yn == 'N') {
          menu = `<li class="nav-item"><input class="folderCheck" type="checkbox" value="`+x.board_folder_sn+`"/><a href="#" class="nav-link"><i class="nav-icon fas fa-folder"></i><p>`+x.board_folder_name+ `</p></a>`;
        }else {
          menu = `<li class="nav-item"><input class="folderCheck" type="checkbox" value="`+x.board_folder_sn+`"/><a href="#" class="nav-link"><i class="nav-icon fas fa-folder"></i><p>`+x.board_folder_name+`<i class="right fas fa-angle-left"></i></p></a><ul menu="`+x.board_folder_sn+`" class="nav nav-treeview" style="display: none;"></ul>`;
        }
        $("ul[menu='"+x.board_folder_upper_sn+"']").append(menu);
      }
    })
  }
  $(document).on('click', '.folderCheck', function(){
    if($('.folderCheck:checked').length > 1) {
      $(this).prop("checked", false);
      alert('중복 체크는 불가능 합니다.');
      return;
    }
    if($('#upperFolderName').val() == '') {
      $('#upperFolderName').val($(this).parent().find('p').eq(0).text());
      $('#upperFolderSn').val($(this).val());
    }else {
      $('#upperFolderName').val('');
      $('#upperFolderSn').val('');
    }
  })
  function saveAction() {
    if($('.folderCheck:checked').length == 0) {
      alert('게시판 폴더를 생성할 상위 폴더를 선택해 주세요.');
      return;
    }else if($('#newFolderName').val() == '' || $('#upperFolderSn').val() =='' || $('#folderSort').val() == '') {
      alert('빈칸을 입력해 주세요.');
      return;
    }
    let data = {
      boardFolderName: $('#newFolderName').val(),
      boardFolderUpperSn: $('#upperFolderSn').val(),
      boardFolderSort: $('#folderSort').val() ,
      //boardFolderUrl: '',
    }
    let result = customAjax.fn_customAjax('/ajax/boardSetting/createMenu', data);
    if(result.flag) {
      $('#menu').empty();
      menu();
      alert(result.rs);
    }else {
      alert('게시판 폴더 생성에 실패했습니다.');
    }
  }
</script>