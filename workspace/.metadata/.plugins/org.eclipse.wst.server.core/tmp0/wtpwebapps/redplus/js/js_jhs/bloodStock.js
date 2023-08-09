/**
 * 
 */

 $.StockList = function(day, type, bType, possession) {
	day = day.replaceAll("-","/");
	$.ajax({
		url: `${mypath}/stockMain.do`,
		type: 'get',
		data: { 
			"day" : day,
		 	"type" : type,
		 	"btype" : bType,
		 	"possession" : possession
		 },
		dataType: 'json',
		success: function(res) {
			if(res!=0){
				result =  "<table border='1' id='detail'>";
				result += `<tr><td>헌혈증코드</td><td>혈액형</td><td>종류</td></tr>`
				$.each(res, function(i, v) {
				result += `<tr>
							<td>${v.bd_code}</td>
							<td>${v.bs_blood_type}</td>
							<td>${v.dt_type}</td>
						   </tr>`;
				})
				result += `</table>`;
			}else{
				result = `<h3>혈액 재고가 존재하지 않습니다.</h3>`	
			}
			$('#stockList').html(result);
		},
		error: function(xhr) {
			alert(xhr.status + " " + xhr.statusText);
		}

	})

}
$.selectNoStockList=function(){
		$('#stockOn').on('click', function(){
			
			 $.ajax({
				url: `${mypath}/inputStockList.do`,
				type: 'post',
				dataType: 'json',
				success: function(res) {
					result = `<label for="fd1">등록하지 않은 혈액 목록</label><br>`
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
	


