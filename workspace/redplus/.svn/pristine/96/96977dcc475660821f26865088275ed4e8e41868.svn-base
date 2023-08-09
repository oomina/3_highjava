/**
 * 
 */

 $.ddListView = function(){
	 
	$.ajax({
		url: `${mypath}/ddAccept.do`,
		type: 'post',
		dataType: 'json',
		success: function(res) {
			if(res=="goback"){
				alert("이미 예약이 있거나, 예약가능일이 아닙니다")
				location.href="/index.do";
			}else if(res != 0){
				result =  "<table border='1' id='detail'>";
				result += `<tr><td>요청코드</td><td>요청마감날짜</td><td>요청혈액종류</td><td>요청혈액형</td><td>병원이름</td></tr>`
				$.each(res, function(i, v) {
				result += `<tr>
							<td>${v.dd_code}</td>
							<td>${v.dd_date}</td>
							<td>${v.dd_bd_type}</td>
							<td>${v.dd_blood_type}</td>
							<td>${v.client_name}</td>
							<td><input type="button" id="selectDd" value="헌혈예약" data-toggle="modal" data-target="#DdTrueCheck"></td>
						   </tr>`;
				})
				result += `</table>`;
			}else{
				result = `<h3>지정헌혈 요청이 없습니다.</h3>`	
			}
			$('#ddList').html(result);
		},
		error: function(xhr) {
			alert(xhr.status + " " + xhr.statusText);
		}
	 
 	})
 }
 
$(document).on('click', '#selectDd', function(){
	ddCode = $(this).closest('tr').find('td:first-child').text();
	ddType = $(this).closest('tr').find('td:eq(3)').text();
	$.ajax({
		url:`${mypath}/ddCheck.do`,
		type:'post',
		dataType: 'json',
		data:{
		"dd_code" : ddCode,
		"dd_blood_type" : ddType
		},
		success: function(res){
			if(res=="no"){
				alert("혈액형이 맞지 않습니다.")
				$('#DdTrueCheck').modal('hide');
			}else{
				result = `<form action="${mypath}/inputDd.do"  method="post">`
				result += `<p class='title'>지정헌혈코드</p>
				           <p class='con'>${res.dd.dd_code}</p>
				           <p class='title'>헌혈날짜</p>
				           <p class='con'>${res.dd.dd_date}</p>
				           <p class='title'>헌혈종류</p>
				           <p class='con'>${res.dd.dd_bd_type}</p>
				           <p class='title'>혈액형</p>
				           <p class='con'>${res.dd.dd_blood_type}</p>
				           <p class='title'>병원명</p>
				           <p class='con'>${res.hos.client_name}</p>
				           <p class='title'>병원위치</p>
				           <p class='con'>${res.hos.client_addr}</p>
				           <input type="hidden" name="code" value="${res.dd.dd_code}">
						   <input type="hidden" name="data" value="${res.dd.dd_date}">
						   <input type="hidden" name="type" value="${res.dd.dd_bd_type}">
				           <input type="submit" value="예약" onclick="return confirmReservation()">
				           </form>`
				 $('#DdCheckList').html(result);
			}
		},
		error: function(xhr){
			alert(xhr.status)
		}
		
	})		
})

function confirmReservation() {
  if (confirm("해당 위치에 지정헌혈 예약을 하시겠습니까?")) {
    return true;
  } else {
    return false;
  }
}

