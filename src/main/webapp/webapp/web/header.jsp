<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="top" class="fixed_nav">
    <div id="logo" class="lf">
        <img class="animated jello" src="${pageContext.request.contextPath}/images/header/logo.png" alt="logo"/>
    </div>
    <div id="top_input" class="lf">
        <input id="input" type="text" placeholder="请输入您要搜索的内容" style="width:360px"/>
        <a href="search.html" class="rt"><img id="search" src="${pageContext.request.contextPath}/images/header/search.png" alt="搜索"/></a>
    </div>
    <div class="rt">
        <ul class="lf">
        		<li><a href="${pageContext.request.contextPath}/user/showPassword.do">${user.username}</a></li>
            <li><a href="favorites.html" title="我的收藏"><img class="care" src="${pageContext.request.contextPath}/images/header/care.png" alt=""/></a><b>|</b></li>
            <li><a href="orders.html" title="我的订单"><img class="order" src="${pageContext.request.contextPath}/images/header/order.png" alt=""/></a><b>|</b></li>
            <li><a href="cart.html" title="我的购物车"><img class="shopcar" src="${pageContext.request.contextPath}/images/header/shop_car.png" alt=""/></a><b>|</b></li>
            <li><a href="help.html">帮助</a><b>|</b></li>
            <c:if test="${user==null}">
            	<li><a href="${pageContext.request.contextPath}/user/showLogin.do">登录</a></li>
        		</c:if>
        		<c:if test="${user!=null}">
            	<li><a href="${pageContext.request.contextPath}/user/logout.do">退出</a></li>
        		</c:if>
        </ul>
    </div>
</header>