<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
    <h2 style="color:Aqua;">search patients details page</h2>
     
    <c:choose>
    <c:when test="${!empty  listRDTO}">
        <table border="1" width="600" height="160" style="border-color: rebeccapurple;background-color: darkgray;color: red">
            <tr>
                <th>patientId</th>
                <th>age</th>
                <th>contact</th>
                <th> wardNo</th>
                <th>patientName</th>
                <th> adress</th>
                <th>problem</th>
                <th>doctor</th>
            </tr>
            <c:forEach var="dto" items="${listRDTO}">
                <tr>
                    <td>${dto.patientId }</td>
                    <td>${dto.age }</td>
                    <td>${dto.contact}</td>
                    <td>${dto.wardNo}</td>
                    <td>${dto.patientName}</td>
                    <td>${dto.adress}</td>
                     <td>${dto.problem}</td>
                      <td>${dto.doctor}</td>
                </tr>
            </c:forEach>
        </table>
    </c:when>

    <c:otherwise>
        <h2>no patients found</h2>
    </c:otherwise>

</c:choose>
