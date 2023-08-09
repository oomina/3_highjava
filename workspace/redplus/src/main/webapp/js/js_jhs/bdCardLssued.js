/**
 * 
 */
$.RadioCheck = function(){
	

 	$('form').on('submit', function(event) {
			$('input[name="bloodType"], input[name="bloodForm"]').each(function() {
			    if (!$('input[name="bloodType"]:checked').val() || !$('input[name="bloodForm"]:checked').val()) {
			      	alert("헌혈 종류와 발급 형태 중 선택되지 않은 항목이 있습니다.");
				  	event.preventDefault();
			      	return false; // 폼 제출 방지
			    }
			});
		});
}

$.InputCheck = function(){		
	$('form').on('submit', function(event) {

		// 각 input 태그들의 내용이 비어있는지 검사
			$('input[type=text], input[type=password]').each(function() {
				if ($(this).val().trim() == '') {
					if ($(this).attr('name') == 'name') {
						alert("이름을 입력해주세요.");
						event.preventDefault();
						return false;
					} else if ($(this).attr('name') == 'regno1' || $(this).attr('name') == 'regno2') {
						alert("주민번호를 입력해주세요.");
						event.preventDefault();
						return false;
				}
				}
			});
		});
}
