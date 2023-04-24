<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

	<meta charset="UTF-8">
	<title>Insert title here</title>

	<link href="../../css/reset.css" rel="stylesheet" />
	<link href="../../css/index.css" rel="stylesheet" />
	
</head>

<body>
	
	<!----------- header 부분 ----------->
	
	<header>
		<div id="home">
			<a href="index"><h1>My 가계부 Ver2.</h1></a>
		</div>
		<nav id="menu">
			<ul>
				<li><a href="#tran/add">가계부 쓰기</a></li>
				<li><a href="#tran/list">가계부 보기</a></li>
				<li><a href="set/category/list">설정</a></li>
				<li><a href="#logIO">로그인/아웃</a></li>
			</ul>
		</nav>
	</header>
	
	
	<!----------- 가운데 몸통 부분 ----------->
	<div id="middle">
	
		<!----------- aside 부분 ----------->
		
		<aside>
			<nav id="menu">
				<ul>
					<li><a href="#tran/add">카테고리 관리</a></li>
					<li><a href="#tran/list">결제수단 관리</a></li>
				</ul>
			</nav>	
		</aside>
		
		<!----------- main 부분 ----------->
		
		<section>
		<div id="main">
			<h1>여기 기본적으로 카테고리 목록이 떠야함니다~</h1>
			<img src="../../images/image.png" width="200px" />
		</div>
		</section>
	
	</div>
	<!----------- footer 부분 ----------->
	
	<footer>
		<h1>All Right Reserved.2023 EyEmilyKim</h1>
	</footer>

</body>

</html>