/**
 * 
 */

 $.ddAcView = function(){
	 
	$.ajax({
		url: `${mypath}/acceptCnt.do`,
		type: 'post',
		dataType: 'json',
		success: function(res) {
			memId = `<span>${res.name}님!</span> 사랑의 헌혈에 참여해 주셔서 감사합니다. 앞으로도 지속적인 관심과 참여 부탁드립니다.`;
			result = `<p>지난 지정헌혈기록</p>
					  <form action="${mypath}/deleteDd.do" method="post">
					  <input type="hidden" name="code" value="${res.info.dd_code}"> 
					  <table><tr><td>헌혈일자</td><td>헌혈종류</td><td>병원</td><td>예약취소</td></tr>`;
			count = `<h2>지정현혈횟수 총<span>${res.count}</span>회</h2>`;
			if(res.info!="0"){
			result += `<tr><td>${res.info.dda_date}</td><td>${res.info.dd_bd_type}</td><td>${res.info.client_name}</td>
			          <td><input type="submit" id="closeButton"  onclick="return confirmReservation()" value="예약취소"></td></tr></table></form>`;
			}else {	
				result += `<tr><td colspan='4'><span>헌혈내역이 존재하지 않습니다.</span></tr></table></form>`;
			}
			
			$('#midContainer').html(count);
			$('#nameContainer').html(memId);
			$('#bottomContainer').html(result);         
			          
		},
		error: function(xhr) {
			alert(xhr.status + " " + xhr.statusText);
		}
	 
	});
}


function confirmReservation() {
  if (confirm("예약을 취소하시겠습니까??")) {
    return true;
  } else {
    return false;
  }
}


 $.ddPrevListView = function(){
	 $.ajax({
		url: `${mypath}/ddPrevList.do`,
		type: 'post',
		dataType: 'json',
		success: function(res) {
			memId = `<span>${res.name}님!</span> 사랑의 헌혈에 참여해 주셔서 감사합니다. 앞으로도 지속적인 관심과 참여 부탁드립니다.`;
			result = `<p>지난 지정헌혈기록</p>
					  <form action="${mypath}/deleteDd.do" method="post">
					  <input type="hidden" name="code" value="${res.info.dd_code}"> 
					  <table><tr><td>헌혈일자</td><td>헌혈종류</td><td>병원</td></tr>`;
			count = `<h2>지정현혈횟수 총<span>${res.count}</span>회</h2>`;
			if(res.info!="0"){
				$.each(res.info, function(i, v) {
					result += `<tr><td>${v.dda_date}</td><td>${v.dd_bd_type}</td><td>${v.client_name}</td></tr>`;
				})
			result += `</table></form>`;
			}else {	
				result += `<tr><td colspan='4'><span>헌혈내역이 존재하지 않습니다.</span></tr></table></form>`;
			}
			
			$('#midContainer').html(count);
			$('#nameContainer').html(memId);
			$('#bottomContainer').html(result);    
		},
		error: function(xhr) {
			alert(xhr.status + " " + xhr.statusText);
		}
	 
 	})
 }