<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_kmw/eq_css/question.css">
</head>
<body>
    <div id="resMain">
        <div id="resNav">
            <img src="../images/replus.png" onclick="location.href='/index.do'">
                <ul>
                    <li><a href="" class="topbar">마이페이지</a></li>
                    <li><a href="" class="topbar">헌혈예약</a></li>
                    <li><a href="" class="topbar">헌혈증기부</a></li>
                    <li><a href="" class="topbar">커뮤니티</a></li>
                    <li><a href="" class="topbar">헌혈정보</a></li>
                </ul>

        </div>
        <div id="container">
            <aside>
                <h2>헌혈참여</h2>
                <nav>
                    <ul id="sidebar">
                        <li>전자문진</li>
                        <li>헌혈의집 찾기</li>
                        <li>헌혈예약</li>
                    </ul>
                </nav>
            </aside>

            <div id="resBox">
                <h2>전자문진</h2>
                <div id="box">
                    <img src="/images/eqimg/헌혈참여2.png" id="join1">
                    <img src="/images/eqimg/헌혈참여1.png" id="join2">
                </div>
                <br><br>
                <button onclick="location.href='/EqLogin.do'" id="questBtn">전자문진 하러가기</button >
            </div>
        </div>

        <footer>

        </footer>
    </div>


</body>
</html>
