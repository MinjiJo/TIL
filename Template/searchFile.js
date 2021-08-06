let chkFileName = '';
let chkFileVer = '';

function search(){
	document.getElementById("fixContainer").style.display ='block';
	const SearchFileName = document.getElementById('search_typing').value;
}
function enterkey() {
	if (window.event.keyCode == 13) {
		// 엔터키가 눌렸을 때 실행할 내용
		search();
	}
}
function addFile() {
	//선택한 모듈 정보 가져오기
	let searchTab = document.getElementById('searchTable');
	for (let i = 1; i < searchTab.rows.length; i++) {
		searchTab.rows[i].cells[3].onclick = function () {
			chkFileName = searchTab.rows[i].cells[0].innerText;
			chkFileVer = searchTab.rows[i].cells[1].innerText;
			alert(chkFileName+" 모듈의 "+chkFileVer+" 버전을 선택하셨습니다.");
		}
	}

	//모듈 검색 결과창 안 보이도록
	document.getElementById("fixContainer").style.display ='none';

	setTimeout(insertRow,1000);
}
function insertRow(){
	//해당 모듈이 추가되어 있는지 확인
	let searchTab = document.getElementById('searchTable');
	let resultTab = document.getElementById('resultTable');
	for (let i = 1; i < resultTab.rows.length; i++) {
		if(chkFileName==resultTab.rows[i].cells[1].innerText){
			alert(chkFileName+" 모듈의 다른 버전이 이미 선택되었습니다. 선택 버전 삭제 후 다시 시도해 주십시오.");
			return false;
		}
	}

	//추가한 모듈 테이블 보이도록
	document.getElementById("resultContainer").style.display ='block';
	
	//추가 테이블에 새 행(Row) 추가
	let newRow = resultTab.insertRow();

	//새 행(Row)에 Cell 추가
	newRow.insertCell(0).innerHTML = '<button class="clickButton" onclick="deleteRow();">삭제</button>';
	newRow.insertCell(1).innerHTML = chkFileName;
	newRow.insertCell(2).innerHTML = chkFileVer;
	newRow.insertCell(3).innerHTML = '오류 내역 수정';
	newRow.insertCell(4).innerHTML = 'Q123456';
	newRow.insertCell(5);
	newRow.insertCell(6);
	newRow.insertCell(7);
	newRow.insertCell(8);
}
function deleteRow() {
	let resultTab = document.getElementById('resultTable');
	for (let i = 1; i < resultTab.rows.length; i++) {
		resultTab.rows[i].cells[0].onclick = function () {
			if(confirm("정말 삭제하시겠습니까?") == true){
				resultTab.deleteRow(i);
				alert("삭제되었습니다.");
			}
			else{
				return ;
			}
		}
	}
}
