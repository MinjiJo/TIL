function search(){
	history.go(0);
}
function enterkey() {
	if (window.event.keyCode == 13) {
		// 엔터키가 눌렸을 때 실행할 내용
		search();
	}
}