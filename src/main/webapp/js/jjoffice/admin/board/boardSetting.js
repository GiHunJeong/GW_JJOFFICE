var boardSetting = {
    global : {

    },
    init : function() {
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
        });
    },
    menu : function() {
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
    },
    saveAction : function() {
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
            boardSetting.menu();
            alert(result.rs);
        }else {
            alert('게시판 폴더 생성에 실패했습니다.');
        }
    }
}