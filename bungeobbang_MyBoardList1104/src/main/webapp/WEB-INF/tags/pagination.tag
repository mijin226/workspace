<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="pagination"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 페이지네이션 -->
<section id="pagination">
	<div class="pagination">
		<!-- 이전 페이지 버튼 -->
		<c:if test="${page > 1}">
			<%--url을 받아와 page가 있다면 변경하고 없다면 추가--%>
			<c:set var="queryWithNewPage"
				value="${fn:contains(queryString, 'page=') ?
								   fn:replace(queryString, 'page='+=page, 'page='+=page-1) :
								   queryString.concat('&page=').concat(page-1)}" />
			<a href="?${queryWithNewPage}" id="pagenationNextValue">&laquo;
				이전</a>
		</c:if>

		<c:set var="startPage" value="${page - 5}" />
		<c:set var="endPage" value="${page + 4}" />

		<c:if test="${startPage < 1}">
			<c:set var="startPage" value="1" />
		</c:if>
		<c:if test="${endPage > totalPage}">
			<c:set var="endPage" value="${totalPage}" />
		</c:if>

		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:choose>
				<c:when test="${i == page}">
					<strong>${i}</strong>
				</c:when>
				<c:otherwise>
					<%--url을 받아와 page가 있다면 변경하고 없다면 추가, 받아올 url이 없는 경우에도 추가--%>
					<c:set var="queryWithNewPage"
						value="${empty queryString ? 'page='.concat(i) :
												(fn:contains(queryString, 'page=') ?
													fn:replace(queryString, 'page='+=page, 'page='+=i) :
													queryString.concat('&page=').concat(i))}" />
					<a href="?${queryWithNewPage}" class="pagenationValue">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="${page < totalPage}">
			<%--url을 받아와 page가 있다면 변경하고 없다면 추가--%>
			<c:set var="queryWithNewPage"
				value="${fn:contains(queryString, 'page=') ?
								   fn:replace(queryString, 'page='+=page, 'page='+=page+1) :
								   queryString.concat('&page=').concat(page+1)}" />
			<a href="?${queryWithNewPage}" id="pagenationNextValue">다음
				&raquo;</a>
		</c:if>
	</div>
</section>