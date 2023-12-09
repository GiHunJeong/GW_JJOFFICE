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
    <a href="index3.html" class="brand-link">
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
                <a href="#" class="d-block">JJOFFICE USER</a>
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
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                <li class="nav-header">TEST MENU</li>
                <li class="nav-item">
                    <a href="javascript:void(0);" onclick="fn_moveMenu1Page('menu1');" class="nav-link">
                        <i class="nav-icon fas fa-th"></i>
                        <p>
                            Menu1
                            <span class="right badge badge-danger">New</span>
                        </p>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="javascript:void(0);" class="nav-link">
                        <i class="nav-icon fas fa-copy"></i>
                        <p>
                            Menu2
                            <i class="fas fa-angle-left right"></i>
                            <span class="badge badge-info right">6</span>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="javascript:void(0);" onclick="fn_moveMenu1Page('menu2');" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Top Menu</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="javascript:void(0);" onclick="fn_moveMenu1Page('menu3');" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Bottom Menu</p>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
        <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
</aside>
<script>
    function fn_moveMenu1Page(menuName) {
        $('#content').load(menuName);
    }
</script>