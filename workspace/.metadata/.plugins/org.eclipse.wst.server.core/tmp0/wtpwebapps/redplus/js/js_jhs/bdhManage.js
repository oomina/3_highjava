/**
 * 
 */

   
$.ResList = function(today) {
	today = today.replaceAll("-","/");
	$.ajax({
		url: `${mypath}/resManage.do`,
		type: 'post',
		data: { "today" : today },
		dataType: 'json',
		success: function(res) {
			result =  "<table border='1' id='detail'>";
			result += `<tr><td>시간</td><td>예약가능인원</td><td>현재예약인원</td></tr>`
			$.each(res, function(i, v) {
				result += `<tr class=${v.day_code} data-toggle="modal" data-target="#DetilaListModal">
							<td>${v.time_code}시</td>
							<td>${v.max_user}명</td>
							<td>${v.cnt_user}명</td>
						   </tr>`;
			})
			result += `</table>`;

			$('#resList').html(result);
		},
		error: function(xhr) {
			alert(xhr.status + " " + xhr.statusText);
		}

	})
	  today = today.replaceAll("/","-");
	  $('#dateId').val(today);
	
}

$(document).on('click', '#detail tr', function(){
		$.ajax({
			url: `${mypath}/resDetail.do`,
			type : `post`,
			data : {
				'time': $(this).find('td:first-child').text(),
				'day' : $(this).attr('class')
				},
			dataType : 'json',
			success : function(res){
			if(res!=0){
				result =  "<table border='1' class='detail'>";
				result += `<tr><td>예약코드</td><td>문진코드</td><td>헌혈종류</td><td>이름</td></tr>`
				$.each(res, function(i, v) {
				result += `<tr>
							<td>${v.res_code}</td>
							<td>${v.eq_code}</td>
							<td>${v.res_type}</td>
							<td>${v.client_name}</td>
						   </tr>`;
				})
			
				result += `</table>`;
			}else{
				result = "<div id='noDetail'><img src='/images/resManage/detailNo.png'>"
				result += "<h2>예약정보가 존재하지 않습니다</h2></div>";
			}
			$('#detailList').html(result);
			},
			error : function(xhr){
				alert(xhr.status);
			}
			
		})
});