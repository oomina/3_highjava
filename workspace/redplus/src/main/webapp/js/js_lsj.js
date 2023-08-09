/**
 * 
 */

// 조회수 증가
$.updateViewServer = function(){
	$.ajax({
		url : `${mypath}/updateView.do`,
		data : {"board_code" : vidx},
		type : 'get',
		success : function(res) {
			//alert(res.flag);
			
			if(res.flag == "ok") {
				
			}
		},
		error : function(xhr){
			alert("상태 : " + xhr.status)
		},
		dataType : 'json'
	})
}

// 내가 쓴 글 페이지 목록
$.myboardListServer = function(clientId, board_modify){
	$.ajax({
		url : `${mypath}/myboardList.do`,
		type : 'post',
		data : {"client_id" : clientId,
				"board_modify" : board_modify},
		success : function(res) {
		code = 
		`<div class="container">
		 </div>
			<div class="container mt-3">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th style="text-align: center;">글번호</th>
							<th style="text-align: center;">제목</th>
							<th style="text-align: center;">작성자</th>
							<th style="text-align: center;">작성일</th>
							<th style="text-align: center;">조회수</th>
						</tr>
					</thead>
					<tbody>`;
		
		$.each(res, function(i, v) {
			code += `<tr id="aa" onclick="location.href='${mypath}/boardInfo.do?board_code=${v.board_code}'">
						<td id="code">${v.board_code}</td>
						<td id="title">${v.board_title}</td>
						<td id="id">${v.client_id}</td>
						<td id="wdate">${v.write_date}</td>
						<td id="cnt">${v.view_cnt}</td>
					</tr>`
		}) // $.each
		$('#myboardList').html(code);
		}, // success 
		error : function(xhr) {
			alert("상태 : " + xhr.status);
		}, // error
		dataType : 'json'
		
	}) // ajax
} // replyPageServer

// 댓글 수정
$.replyUpdateServer = function() {
	$.ajax({
		url : `${mypath}/replyUpdate.do`,
		type : 'post',
		data : fdata,
		success : function(res){
			//alert("성공");
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status)
		},
		dataType : 'json'
	})
}

// 댓글 삭제
$.replyDeleteServer = function() {
	$.ajax({
		url : `${mypath}/replyDelete.do`,
		type : 'get',
		data : { "reply_code" : vidx},
		success : function(res){
			//alert("성공");
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	})
}


// 댓글 목록
$.replyListServer = function(boardCode){
	$.ajax({
		url : `${mypath}/replyList.do`,
		type : 'post',
		data : {"board_code" : boardCode},
		success : function(res) {
		rcode = " ";
		$.each(res.reply, function(i, v){
			rcode += 
			`<div class="reply-body">
				<p class="p1" style="text-align:right;">
					<span>${v.reply_modify}</span>
				</p>
				<div class="form-group">
					<div class="input-group">
						<span class="replyAuthorId">${v.client_id}</span>
						<textarea class="form-control" readonly="readonly" id="rcont">${v.reply_content}</textarea>`;
			if(v.client_id == res.login || res.login != '0'){
			rcode += `<button type="button" class="btn btn-outline-primary btn-sm action reply_code" 
						 name="modify" idx="${v.reply_code}" data-bs-toggle="modal" data-bs-target="#myModal">수정</button>
						<button type="button" class="btn btn-outline-danger btn-sm action reply_code" name="delete" idx="${v.reply_code}">삭제</button>`
			}

			rcode += `</div></div></div><br>`;
			}) // each
			$('#replyResult').html(rcode);
		}, // success 
		error : function(xhr) {
			alert("상태 : " + xhr.status);
		}, // error
		dataType : 'json'
		
	}) // ajax
} // replyListServer

// 페이지 목록
$.listPageServer = function(cpage){
	vtype = $('#stype option:selected').val();
	vword = $('#sword').val();
	
	$.ajax({
		url : `${mypath}/boardList.do`,
		type : 'post',
		data : {
			"page" : cpage, 
			"stype" : vtype,
			"sword" : vword
		},
		success : function(res) {
		
		code = 
		`<div class="container">
		 </div>
			<div class="container mt-3">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th style="text-align: center;">글번호</th>
							<th style="text-align: center;">제목</th>
							<th style="text-align: center;">작성자</th>
							<th style="text-align: center;">작성일</th>
							<th style="text-align: center;">조회수</th>
						</tr>
					</thead>
					<tbody>`
					
		$.each(res.datas, function(i, v) {
			code += `<tr class="action" id="updateView" name="updateView" idx="${v.board_code}"
						onclick="location.href='${mypath}/boardInfo.do?board_code=${v.board_code}'" >
						<td id="code">${v.board_code}</td>
						<td id="title">${v.board_title}</td>
						<td id="id">${v.client_id}</td>
						<td id="wdate">${v.write_date}</td>
						<td id="cnt">${v.view_cnt}</td>
					</tr>`
		}) // $.each
		
		code += `</tbody>
			</table>
			</div>`;
			
		// 리스트 출력
		$('#result').html(code);
		
		// 페이지 처리
		// 이전
		pager = "";
		pager += `<ul class="pagination">`;
		if (res.sp > 1) {
			pager += `<li class="page-item"><a id="prev" class="page-link" href="#">Previous</a></li>`;
		}
			
		// 페이지 번호
		for(i = res.sp; i <= res.ep; i++) {
			if(i == currentPage){
				// active 
				pager += `<li class="page-item active"><a class="page-link pageno" href="#">${i}</a></li>`;
			} else {
				pager += `<li class="page-item"><a class="page-link pageno" href="#">${i}</a></li>`;
			}
		}
		// 다음
		if(res.ep < res.tp){
			pager += `<li class="page-item"><a id="next" class="page-link" href="#">Next</a></li>`;
		}
		pager += `</ul>`
		$('#pageList').html(pager);
			
		}, // success 
		error : function(xhr) {
			alert("상태 : " + xhr.status)
		}, 
		dataType : 'json'
	})
} // listPageServer

$.listPageServer2 = function(cpage){
    vtype = $('#stype option:selected').val();
    vword = $('#sword').val();
    
    $.ajax({
        url : `${mypath}/boardList.do`,
        type : 'post',
        data : {
            "page" : cpage, 
            "stype" : vtype,
            "sword" : vword
        },
        success : function(res) {
            code = 
            `<div class="container">
             </div>
                <div class="container mt-3">
                    <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
                        <thead>
                            <tr>
                                <th style="text-align: center;">글번호</th>
                                <th style="text-align: center;">제목</th>
                                <th style="text-align: center;">작성자</th>
                                <th style="text-align: center;">작성일</th>
                                <th style="text-align: center;">조회수</th>
                            </tr>
                        </thead>
                        <tbody>`
                        
            $.each(res.datas, function(i, v) {
                code += `<tr class="action" id="updateView" name="updateView" idx="${v.board_code}"
                            onclick="location.href='${mypath}/boardInfo.do?board_code=${v.board_code}'" >
                            <td id="code">${v.board_code}</td>
                            <td id="title">${v.board_title}</td>
                            <td id="id">${v.client_id}</td>
                            <td id="wdate">${v.write_date}</td>
                            <td id="cnt">${v.view_cnt}</td>
                        </tr>`
            }) // $.each
            
            code += `</tbody>
                </table>
                </div>`;
                
            // 리스트 출력
            $('#result').html(code);
            
		// 페이지 처리
		// 이전
		pager = "";
		pager += `<ul class="pagination">`;
		if (res.sp > 1) {
			pager += `<li class="page-item"><a id="prev" class="page-link" href="#">Previous</a></li>`;
		}
			
		// 페이지 번호
		for(i = res.sp; i <= res.ep; i++) {
			if(i == currentPage){
				// active 
				pager += `<li class="page-item active"><a class="page-link pageno" href="#">${i}</a></li>`;
			} else {
				pager += `<li class="page-item"><a class="page-link pageno" href="#">${i}</a></li>`;
			}
		}
		// 다음
		if(res.ep < res.tp){
			pager += `<li class="page-item"><a id="next" class="page-link" href="#">Next</a></li>`;
		}
		pager += `</ul>`
		$('#pageList').html(pager);
			
		}, // success 
		error : function(xhr) {
			alert("상태 : " + xhr.status)
		}, 
		dataType : 'json'
	})
} // listPageServer


