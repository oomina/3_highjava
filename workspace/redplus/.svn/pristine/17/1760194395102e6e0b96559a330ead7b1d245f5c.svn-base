/**
 * 
 * 
 */
$.loginerror = function() {
	$('form').on('submit', function(event) {

		// 각 input 태그들의 내용이 비어있는지 검사
		$('input[type=text], input[type=password]').each(function() {
			if ($(this).val().trim() == '') {
				if ($(this).attr('type') == 'text') {
					alert("아이디를 입력해주세요.");
					event.preventDefault();
					return false;
				} else if ($(this).attr('type') == 'password') {
					alert("비밀번호를 입력해주세요.");
				}
				event.preventDefault();
			}
		});
	});
}