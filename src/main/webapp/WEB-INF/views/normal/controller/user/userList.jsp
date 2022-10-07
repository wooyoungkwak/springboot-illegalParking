<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2022-03-02
  Time: 오후 7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://stripes.sourceforge.net/stripes.tld" prefix="stripes" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layoutTags" %>
<%@ page import="com.teraenergy.illegalparking.model.entity.report.enums.ReportFilterColumn" %>
<%@ page import="com.teraenergy.illegalparking.model.entity.report.enums.ReportStateColumn" %>
<%@ page import="com.teraenergy.illegalparking.model.entity.report.enums.StateType" %>

<% String contextPath = request.getContextPath(); %>

<stripes:layout-render name="/WEB-INF/views/layout/navHtmlLayout.jsp">

    <!-- nav -->
    <stripes:layout-component name="nav">
        <stripes:layout-render name="/WEB-INF/views/layout/component/navLayout.jsp"/>
    </stripes:layout-component>

    <!-- side -->
    <stripes:layout-component name="side">
        <jsp:include page="side.jsp" flush="true"/>
    </stripes:layout-component>

    <!-- content -->
    <stripes:layout-component name="contents">
        <main  id="reportMain">
            <div class="container-fluid px-4">
                <h1 class="mt-4">사용자</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active">${subTitle} > 관공서</li>
                </ol>
                <div class="card mb-4 shadow-sm rounded">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        관공서 정보
                    </div>
                    <div class="card-body">
                        <form class="row mb-3 g-3">
                            <input type="hidden" id="pageNumber" name="pageNumber" value="${pageNumber}"/>
                            <input type="hidden" id="pageSize" name="pageSize" value="${pageSize}"/>
                            <div class="col-2">
                                <a class="btn btn-primary"><i class="fa fa-city"></i> 관공서추가</a>
                            </div>
                            <div class="col-1"></div>
                            <div class="col-1">
                                <tags:filterTag id="filterColumn" enumValues="${ReportFilterColumn.values()}" column="${filterColumn}"/>
                            </div>
                            <div class="col-4">
                                <tags:searchTag id="searchStr" searchStr="${searchStr}"/>
                                <tags:searchTagWithSelect id="searchStr2" searchStr="${searchStr2}" items="${ResultType.values()}" />
                            </div>
                            <div class="col-1"></div>
                            <div class="col-3"></div>
                        </form>
                        <table class="table table-hover table-bordered" id="reportTable">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">지역</th>
                                    <th scope="col">관공서명</th>
                                    <th scope="col">아이디</th>
                                    <th scope="col">관리그룹</th>
                                    <th scope="col">신고접수건</th>
                                    <th scope="col">대기</th>
                                    <th scope="col">미처리</th>
                                    <th scope="col">처리</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach begin="1" end="10" varStatus="status">
                                    <tr>
                                        <td>${status.index}</td>
                                        <td>전남</td>
                                        <td>나주시청 차량민원과</td>
                                        <td>hong</td>
                                        <td>32</td>
                                        <td>879</td>
                                        <td>7</td>
                                        <td>56</td>
                                        <td>816</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <tags:pageTag pageNumber="${pageNumber}" isBeginOver="${isBeginOver}" isEndOver="${isEndOver}" totalPages="${totalPages}" items="10,25,50" pageSize="${pageSize}"/>
                    </div>
                </div>
            </div>
        </main>

        <layoutTags:reportSetTag items="${ResultType.values()}" />
    </stripes:layout-component>

    <!-- footer -->
    <stripes:layout-component name="footer">
        <stripes:layout-render name="/WEB-INF/views/layout/component/footerLayout.jsp"/>
    </stripes:layout-component>

    <!-- javascript -->
    <stripes:layout-component name="javascript">
        <script src="<%=contextPath%>/resources/js/report/reportList-scripts.js"></script>
        <script type="application/javascript">
            if ( '${filterColumn}' === 'RESULT') {
                $('#searchStrGroup').hide();
                $('#searchStr2Group').show();
            } else {
                $('#searchStrGroup').show();
                $('#searchStr2Group').hide();
            }
        </script>
    </stripes:layout-component>

</stripes:layout-render>