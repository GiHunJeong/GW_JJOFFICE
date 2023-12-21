var adminPage = {
    global: {

    },
    init : function() {
        $(document).on('click', '#test', function() {
            alert('Home 눌름');
        });
    },
    userModeAction : function() {
        location.href = "/main";
    },
    logoutAction : function() {
        location.href = "/logout";
    },
    fn_openPage : function(menuName) {
        $('#adminPageContent').load(menuName);
    },
}