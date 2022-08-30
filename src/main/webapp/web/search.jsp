<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>商品搜索页面</title>
<link rel="stylesheet" href="../css/header.css" />
<link rel="stylesheet" href="../css/search.css" />
<link rel="stylesheet" href="../css/footer.css" />
</head>
<!-- 页面顶部-->
<jsp:include page="header.jsp"></jsp:include>
<!-- nav主导航-->
<nav id="nav">
	<ul>
		<li><a href="index.html" class="acti">首页</a></li>
		<li><a href="index.html#computer">电脑办公</a></li>
		<li><a href="index.html#stationery">办公文具</a></li>
	</ul>
</nav>

<body>
	<div class="big" style="height:1000px">
		<form name="" action="" method="post">
			<section id="section">
				<p class="header">全部结果>笔记本</p>
				<div id="wrap">
					<c:forEach items="${glist}" var="g">
						<div class="lf box" id="d1" style="width: 220px; height: 240px;">
							<div class="info">
								<div class="img pic">
								<a href="#" onclick="toItemInfo(${g.id},${g.categoryId})">
									<img src="../${g.image}" alt=""/>
								</a>		 
								</div>
								<div class="describe">
									<p style="height: 32px; overflow: hidden"
										onclick="toItemInfo(${g.id},${g.categoryId})">${g.title}</p>
									<span class="price"><b>￥</b><span class="priceContent">${g.price}</span></span>
									<span class="addCart"><img id="collect"
										src="../images/search/care.png" alt="" /><a
										href="javascript:void(0);" class="add_cart">加入购物车</a></span>
									<!--<span class="succee" style="display: none"> 
								<img src="/images/search/product_true.png" alt="" /> 
								<span>已移入购物车</span>
							</span>-->
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</section>
		</form>
	</div>
	<div align="right">
	共${count}条记录|共${pageSize}页
	<c:forEach var="i" begin="1" end="${pageSize}">
		<a href=
		<c:if test="${categoryId!=null}">"../goods/showGoods.do?page=${i}&categoryId=${categoryId}"</c:if>
		<c:if test="${categoryId==null}">"../goods/showGoodsByTitle.do?page=${i}&title=${title}"</c:if> 
		 <c:if test="${currentPage==i}">style="color:red;"</c:if>>${i}</a>
	</c:forEach>
	</div>
	<!-- 尾部-->
	<!-- 页面底部-->
	<div class="foot_bj">
		<div id="foot">
			<div class="lf">
				<p class="footer1">
					<img src="../images/footer/logo.png" alt="" class=" footLogo" />
				</p>
				<p class="footer2">
					<img src="../images/footer/footerFont.png" alt="" />
				</p>
			</div>
			<div class="foot_left lf">
				<ul>
					<li><a href="#"><h3>买家帮助</h3></a></li>
					<li><a href="#">新手指南</a></li>
					<li><a href="#">服务保障</a></li>
					<li><a href="#">常见问题</a></li>
				</ul>
				<ul>
					<li><a href="#"><h3>商家帮助</h3></a></li>
					<li><a href="#">商家入驻</a></li>
					<li><a href="#">商家后台</a></li>
				</ul>
				<ul>
					<li><a href="#"><h3>关于我们</h3></a></li>
					<li><a href="#">关于达内</a></li>
					<li><a href="#">联系我们</a></li>
					<li><img src="../images/footer/wechat.png" alt="" /> <img
						src="../images/footer/sinablog.png" alt="" /></li>
				</ul>
			</div>
			<div class="service">
				<p>学子商城客户端</p>
				<img src="../images/footer/ios.png" class="lf"> <img
					src="../images/footer/android.png" alt="" class="lf" />
			</div>
			<div class="download">
				<img src="../images/footer/erweima.png">
			</div>
			<!-- 页面底部-备案号 #footer -->
			<div class="record">&copy;2017 达内集团有限公司 版权所有 京ICP证xxxxxxxxxxx</div>
		</div>
	</div>
	<div class="modal" style="display: none">
		<div class="modal_dialog">
			<div class="modal_header">操作提醒</div>
			<div class="modal_information">
				<img src="../images/model/model_img2.png" alt="" /> <span>将您的宝贝加入购物车？</span>

			</div>
			<div class="yes">
				<span>确定</span>
			</div>
			<div class="no">
				<span>取消</span>
			</div>
		</div>
	</div>
	<script src="../js/jquery-3.1.1.min.js"></script>
	<script src="../js/index.js"></script>
	<script src="../js/jquery.page.js"></script>
	<script>
	$(".add_cart").click(function(){
		$(".modal").show();
		$(".modal .modal_information span").html("将您的宝贝加入购物车?");
	})
	$(".yes").click(function(){
	    $(".modal").hide();
	})
	$('.no').click(function(){
    	$('.modal').hide();
    	
    })
</script>
	<!--<script type="text/javascript">
	// var status = ${status};
	var pages = ${pageBean.totalPages};
	var index = ${pageBean.pageIndex};
	$(".tcdPageCode").createPage({
		// 总页数
	    pageCount:pages,
	 	// 起始页
	    current:index,
	    backFn:function(p){
	    	// 执行代码
	    	window.location.href="http://localhost:18888/search.html?q=${q}&page="+p;
	    }
	});
</script>-->
	<!--<script type="text/javascript">
    /* 商品详情页  */
	function toItemInfo(id) {
		if (id) {
			window.location.href="/toItemInfo/"+id+".html";
		}else {
			alert("商品id不存在");
		}
	} 
</script>-->
	<script type="text/javascript">
	/* 商品详情页  */
	function toItemInfo(id,categoryId) {
		location.href = "../goods/showGoodsInfo.do?id="+id+"&categoryId="+categoryId;
	} 
	/**添加到收藏**/
    $("#collect").click(function(e){
    	$(".modal").show();
		$(".modal .modal_information span").html("将您的宝贝加入收藏夹");
    })
    $(".yes").click(function(){
	    $(".modal").hide();
	    $('#collect').attr("src","../images/search/care1.png");
    })
</script>
</body>
</html>