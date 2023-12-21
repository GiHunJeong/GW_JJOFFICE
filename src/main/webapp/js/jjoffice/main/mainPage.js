var mainPage = {
    global: {

    },
    init : function() {
        $(document).on('click', '#test', function() {
            alert('Home 눌름');
        });
        if($('#alertMsg').val() != '') {
            alert($('#alertMsg').val());
        }
    },
    adminModeAction : function() {
        location.href = "/admin";
    },
    logoutAction : function() {
        location.href = "/logout";
    },
    fn_openPage : function(menuName) {
        $('#content').load(menuName);
    },
    menu : function() {
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
}