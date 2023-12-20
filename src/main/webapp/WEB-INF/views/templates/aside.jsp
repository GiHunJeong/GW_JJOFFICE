<%--
  Created by IntelliJ IDEA.
  User: 쩡키
  Date: 2023-12-08
  Time: AM 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <!-- 회사로고 -->
    <a href="/main" class="brand-link">
        <img src="resources/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
        <span class="brand-text font-weight-light">JJOFFICE</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <!-- 유저사진 & 이름 -->
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
                <img src="resources/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
            </div>
            <div class="info">
                <a href="#" class="d-block">${empInfo.empName}</a>
            </div>
        </div>

        <!-- SidebarSearch Form -->
        <!-- 사이드바 검색 -->
        <%--<div class="form-inline">
            <div class="input-group" data-widget="sidebar-search">
                <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
                <div class="input-group-append">
                    <button class="btn btn-sidebar">
                        <i class="fas fa-search fa-fw"></i>
                    </button>
                </div>
            </div>
        </div>--%>

        <!-- Sidebar Menu -->
        <!-- 메뉴 -->
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar nav-child-indent flex-column" data-widget="treeview" role="menu" data-accordion="false">
                <li class="nav-header">TEST MENU</li>
                <li class="nav-item">
                    <a href="javascript:void(0);"  class="nav-link">
                        <i class="nav-icon fas fa-pen"></i>
                        <p>
                            전자결재
                            <i class="fas fa-angle-left right"></i>
                            <span class="right badge badge-danger">New</span>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="javascript:void(0);" onclick="fn_openPage('docWrite');" class="nav-link">
                                <i class="far fa-copy nav-icon"></i>
                                <p>기안</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="javascript:void(0);" onclick="fn_openPage('sentDocBox');" class="nav-link">
                                <i class="far fa-copy nav-icon"></i>
                                <p>발신 문서함</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="javascript:void(0);" onclick="fn_openPage('receiveDocBox');" class="nav-link">
                                <i class="far fa-copy nav-icon"></i>
                                <p>수신 문서함</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="javascript:void(0);" class="nav-link">
                        <i class="nav-icon fas fa-user"></i>
                        <p>
                            근태관리
                            <i class="fas fa-angle-left right"></i>
                            <span class="badge badge-info right">6</span>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="javascript:void(0);" onclick="fn_openPage('menu1');" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>일일근태등록</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="javascript:void(0);" onclick="fn_openPage('menu2');" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>근태현황</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="javascript:void(0);" onclick="fn_openPage('menu1');" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>출장신청</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="javascript:void(0);" onclick="fn_openPage('menu2');" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>휴가신청</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <%-- 게시판 트리뷰 --%>
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
                <%-- 게시판 트리뷰 --%>
            </ul>
        </nav>
        <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
</aside>
<script>
    function fn_openPage(menuName) {
        $('#content').load(menuName);
    }
    menu();
    function menu() {
        let menuList = customAjax.fn_customAjax('/ajax/boardSetting/menuList');
        $.each(menuList.rs, function(i, x) {
            let menu = '';
            if(x.board_folder_dept == '0') {
                if(x.board_folder_child_yn == 'N') {
                    menu = `<li class="nav-item"><a href="#" class="nav-link"><i class="nav-icon fas fa-folder"></i><p>`+x.board_folder_name+ `</p></a>`;
                }else {
                    menu = `<li class="nav-item"><a href="#" class="nav-link"><i class="nav-icon fas fa-folder"></i><p>`+x.board_folder_name+`<i class="right fas fa-angle-left"></i></p></a><ul menu="`+x.board_folder_sn+`" class="nav nav-treeview" style="display: none;"></ul>`;
                }
                $('#menu').append(menu);
            }else if(x.board_folder_dept == '1') {
                if(x.board_folder_child_yn == 'N') {
                    menu = `<li class="nav-item"><a href="#" class="nav-link"><i class="nav-icon fas fa-folder"></i><p>`+x.board_folder_name+ `</p></a>`;
                }else {
                    menu = `<li class="nav-item"><a href="#" class="nav-link"><i class="nav-icon fas fa-folder"></i><p>`+x.board_folder_name+`<i class="right fas fa-angle-left"></i></p></a><ul menu="`+x.board_folder_sn+`" class="nav nav-treeview" style="display: none;"></ul>`;
                }
                $("ul[menu='"+x.board_folder_upper_sn+"']").append(menu);
            }else if(x.board_folder_dept == '2') {
                if(x.board_folder_child_yn == 'N') {
                    menu = `<li class="nav-item"><a href="#" class="nav-link"><i class="nav-icon fas fa-folder"></i><p>`+x.board_folder_name+ `</p></a>`;
                }else {
                    menu = `<li class="nav-item"><a href="#" class="nav-link"><i class="nav-icon fas fa-folder"></i><p>`+x.board_folder_name+`<i class="right fas fa-angle-left"></i></p></a><ul menu="`+x.board_folder_sn+`" class="nav nav-treeview" style="display: none;"></ul>`;
                }
                $("ul[menu='"+x.board_folder_upper_sn+"']").append(menu);
            }else if(x.board_folder_dept == '3') {
                if(x.board_folder_child_yn == 'N') {
                    menu = `<li class="nav-item"><a href="#" class="nav-link"><i class="nav-icon fas fa-folder"></i><p>`+x.board_folder_name+ `</p></a>`;
                }else {
                    menu = `<li class="nav-item"><a href="#" class="nav-link"><i class="nav-icon fas fa-folder"></i><p>`+x.board_folder_name+`<i class="right fas fa-angle-left"></i></p></a><ul menu="`+x.board_folder_sn+`" class="nav nav-treeview" style="display: none;"></ul>`;
                }
                $("ul[menu='"+x.board_folder_upper_sn+"']").append(menu);
            }
        })
    }
</script>