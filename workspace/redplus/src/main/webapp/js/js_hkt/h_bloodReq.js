/**
 * 
 */


$(document).ready(() => {
	 let data = [];
	
	 
  $.ajax({
    url: `/hos/bdrequest.do`,
    type: 'post',
    dataType: 'json',
    async: false, // 동기적으로 실행
    success: function(res) {
      data = res;
    },
    error: function(xhr) {
      alert(xhr.status + " " + xhr.statusText);
    }
  })

	
	
  const tbody = $('#stockList');
  const bloodTypeSelect = $('#blood-type');
  const bloodDtTypeSelect = $('#blood-dt-type');
  const dateInput = $('#dateId');

  function clearTable() {
    tbody.empty();
  }

  function renderTable(dataArray) {
 				result =  "<table border='1' id='detail'>";
				result += `<tr><td>보유혈액원</td><td>혈액원입고날짜</td><td>헌혈증코드</td><td>혈액형</td><td>종류</td><td>이송요청</td></tr>`
				$.each(dataArray, function(i, v) {
				result += `<tr>
							<td>${v.bd_region}혈액원</td>
							<td>${v.store_day}</td>
							<td>${v.bd_code}</td>
							<td>${v.bs_blood_type}</td>
							<td>${v.dt_type}</td>
							<td><button class="req" idx="${v.bd_code}">공급요청</button></td>
						   </tr>`;
				})
				result += `</table>`;
				$('#stockList').html(result);
    
  }
	searchDate = dateInput.val();
  function handleSearch() {
    const searchBloodType = bloodTypeSelect.val();
    const searchDate = dateInput.val().replace(/-/g, '/');
    const searchDtType = bloodDtTypeSelect.val();
    const filteredData = data.filter(item => {
      if (searchDate && item.store_day !== searchDate) {
        return false;
      }
      if (searchBloodType && item.bs_blood_type !== searchBloodType) {
        return false;
      }
      if (searchDtType && item.dt_type !== searchDtType) {
        return false;
      }
      return true;
    });
    clearTable();
    if (filteredData.length > 0) {
      renderTable(filteredData);
    } else {
      result = `<table border='1' id='detail'><h3>혈액 재고가 존재하지 않습니다.</h3></table>`;
			$('#stockList').html(result);
    }
  }

  // 검색 조건이 없는 상태에서 초기 전체 리스트 출력
  renderTable(data);

  // 검색 조건 변경 시 실시간으로 검색 결과 출력
  dateInput.on('change', handleSearch);
  bloodTypeSelect.on('change', handleSearch);
  bloodDtTypeSelect.on('change', handleSearch);
  
  // 공급요청 버튼 누를시 동작
  $(document).on('click', '.req', function(){
	  vidx = $(this).attr('idx');
	  console.log("vidx값은" + vidx);
	  if (confirm(vidx + ' 혈액을 공급 요청하시겠습니까??')) {
	  $.ajax({
		  url: `/hos/bdrequest/deliveryReq.do`,
		  data: { "bdcode" : vidx },
		  type: 'post',
		  dataType: 'text',
		  success: function(res) {
			  alert(res);
			  location.reload();
			
		  },
			error: function(xhr) {
					alert("요청실패" + xhr.status + " " + xhr.statusText);
			}
		  
	  })
	  }
  })
  
  //모달이 열렸을때
  $('#stockModal').on('show.bs.modal', function () {
  	notList = [];
  	
    $.ajax({
    url: `/hos/bdrequest/notRecevieList.do`,
    type: 'post',
    dataType: 'json',
    success: function(res) {
      notList = res;
      if (notList.length > 0) {
      renderTable2(notList);
      } else {
		  result = `<table border='1' id='detail'><h3>미수령 혈액이 존재하지 않습니다.</h3></table>`;
			$('#stockNotList').html(result);
	  }
      
    },
    error: function(xhr) {
      alert(xhr.status + " " + xhr.statusText);
    }
    })
    
    function renderTable2(dataArray) {
			result =  "<table border='1' id='detail'>";
			result += `<tr><td>발송처</td><td>출고날짜</td><td>혈액코드</td><td>혈액형</td><td>종류</td><td>수령확인</td></tr>`
			$.each(dataArray, function(i, v) {
			result += `<tr>
						<td>${v.bd_region}혈액원</td>
						<td>${v.release_day}</td>
						<td>${v.bd_code}</td>
						<td>${v.bs_blood_type}</td>
						<td>${v.dt_type}</td>
						<td><button class="recv" idx="${v.bd_code}">입고</button></td>
					   </tr>`;
			})
			result += `</table>`;
			$('#stockNotList').html(result);
    
  }

	});
	
	  // 수령확인 버튼 누를시 동작
  $(document).on('click', '.recv', function(){
	  vidx = $(this).attr('idx');
	  if (confirm(vidx + ' 혈액을 수령하셨습니까?')) {
	  $.ajax({
		  url: `/hos/bdrequest/reciveCheck.do`,
		  data: { "bdcode" : vidx },
		  type: 'post',
		  dataType: 'text',
		  success: function(res) {
			  alert(res);
			  location.reload();
			
		  },
			error: function(xhr) {
					alert("요청실패" + xhr.status + " " + xhr.statusText);
			}
		  
	  })
	  }
  })
	
});



$.selectNoStockList=function(){
		$('#stockOn').on('click', function(){
			
			 $.ajax({
				url: `${mypath}/inputStockList.do`,
				type: 'post',
				dataType: 'json',
				success: function(res) {
					result = `<label for="fd1"> 목록</label><br>`
		  			if(res!=0){
		  				result =`<label id="stockLabel" for="noStock">등록되지 않은 혈액 목록<br>
		  				 		<select name="noStock" id="noStock">
		  						<option>선택하세요</option>`
							$.each(res, function(i, v) {
								result += "<option>"+v.bd_code+"</option>";
							})
						result += "</select>";
					}else{
						result = `<h2>모든 재고를 등록하였습니다</h2>`;
					}
					result += "<div id='inputForm'></div>";
					$('#stockNoList').html(result);
				},
				error: function(xhr) {
					alert(xhr.status + " " + xhr.statusText);
				}	
			});
		 });
}


$(document).on('change', '#noStock', function(){
	 $.ajax({
			url: `${mypath}/detailStockList.do`,
			type: 'post',
			data: {
				"bd_code" : $(this).val()
			},
			dataType: 'json',
			success: function(res) {
				result = `<form action="${mypath}/inputStock.do" method="post" id='inputStockForm'>
				<label for="code">혈액코드</label><br>
				<input type='text' readonly='readonly' name='code' value='${res.bd_code}'><br>
				<label for="day">보관날짜</label><br>
				<input type='text' readonly='readonly' name='day' value='${res.bd_date}'><br>
				<label for="type">헌혈종류</label><br>
				<input type='text' readonly='readonly' name='type' value='${res.bd_type}'><br>
			    <label for="btype">혈액형</label><br>
				<input type='text' readonly='readonly' name='btype' value='${res.bd_btype}'><br>
				<input type='hidden' name='id' value='${res.bdh_id}'><br> 
				<input type='submit' value='등록'>  
            	</form>`    
            	
            	$('#inputForm').html(result);
			},
			
			error: function(xhr) {
				alert(xhr.status + " " + xhr.statusText);
			}	
		});
});
	


