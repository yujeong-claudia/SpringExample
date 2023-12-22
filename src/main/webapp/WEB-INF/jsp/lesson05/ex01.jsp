<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(1)</title>
</head>
<body>
	<h1>1. 변수 정의하기 (c:set)</h1>
	<c:set var="number1" value="100"/>
	<c:set var="number2">250</c:set>
	number1: ${number1} <br>
	number2: ${number2} <br>
	number1 + number2: ${number1 + number2}
	
	<h1>2. 변수 출력하기 (c:out)</h1>
	<c:out value="Hello world"/> <br>
	<c:out value="${number1}"/> <br>
	
	<%-- 얼럿창 안 띄워지고 글자로 들어감 --%>
	<%-- 문자열 escape: 코드가 나오지않고 글자로 나오는 처리 --%>
	<c:out value="<script>alert('얼럿창 띄우기')</script>"/> <br>
	<c:out value="<script>alert('얼럿창 띄우기')</script>"/> escapeXml="true" <br>
	<%-- <c:out value="<script>alert('얼럿창 띄우기')</script>"/> escapeXml="false" <br>--%>
	
	<h1>3. 조건문(c:if)</h1>
	<c:if test="${number1 > 50}">
		number1은 50보다 크다.<br>
	</c:if>
	<c:if test="${number1 == 100}">
		number1은 100이다.<br>
	</c:if>
	<%-- ==으로 안되면 eq로 해줘야 값비교이다. eq가 정석 --%>
	<c:if test="${number1 eq 100}">
		number1은 100이다.<br>
	</c:if>
	<%-- 같지않다 --%>
	<c:if test="${number1 != 50}">
		number1은 50이 아니다.<br>
	</c:if>
	<%-- not eq 이 ne이다 --%>
	<c:if test="${number1 ne 50}">
		number1은 50이 아니다.<br>
	</c:if>
	<%-- 나중에 프로젝트에서 많이쓴다 --%>
	<c:if test="${empty number1}">
		number1은 비어있다.<br>
	</c:if>
	<c:if test="${!empty number1}">
		number1은 비어있지않다.<br>
	</c:if>
	<%-- 비어있지않다의 정석: not empty --%>
	<c:if test="${not empty number1}">
		number1은 비어있지않다.<br>
	</c:if>
	
</body>
</html>