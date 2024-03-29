# Git 명령어

- git init : 초기 git 생성
- git clone <url> : 코드가져오기 ( git clone https://github.com/MinjiJo/TIL/new/master )
- git checkout <branch_name> : 브랜치 선택하기
- git checkout -t <remote_path/branch_name> : 원격 브랜치 선택하기
- git checkout -b <remote_path/branch_name> : 새로운 브랜치 만들면서 이동
- git branch <branch_name> : 브랜치 생성하기
- git branch -r : 원격 브랜치 목록보기
- git branch -a : 로컬 브랜치 목록보기
- git branch -m <branch_name> <change_branch_name> : 브랜치 이름 바꾸기
- git branch -d <branch_name> : 브랜치 삭제하기
- git push <remote_name> — delete <branch_name> : 원격 브랜치 삭제하기 ( git push origin — delete gh-pages )
- git add <file_path> : 수정한 코드 선택하기 ( git add * )
- git commit -m "<commit_description>" : 선택한 코드 설명 적기 ( git commit -m “Edit gitCommand.md”)
- git commit -a -m "your commit message here" : git add와 commit을 동시에 하기
- git push <romote_name> <branch_name> : add하고 commit한 코드 git server에 보내기 (git push origin master)
- git pull : git서버에서 최신 코드 받아와 merge 하기
- git fetch : git서버에서 최신 코드 받아오기
- git reset — hard HEAD^ : commit한 이전 코드 취소하기
- git reset — soft HEAD^ : 코드는 살리고 commit만 취소하기
- git reset — merge : merge 취소하기
- git reset — hard HEAD && git pull : git 코드 강제로 모두 받아오기
- git config — global user.name “<user_name>” : git 계정Name 변경하기
- git config — global user.email “<user_email>” : git 계정Mail변경하기
- git stash / git stash save “<description>” : 작업코드 임시저장하고 브랜치 바꾸기
- git stash pop : 마지막으로 임시저장한 작업코드 가져오기
- git branch —-set-upstream-to <remote_path>/<branch_name> : branch 연동


### 일단 무조건! git 올리려고 하는 폴더 위치는 꼭 확인할 것!

### 기본 브랜치 master -> main (기본 셋팅이 달라진 것)
 - 기본 브랜치 확인하고 작성해야 함

###### 여러 명이 같이 깃을 이용하여 협동 프로젝트를 할 때
 - 먼저 코드 작성 시작 전에 각자 git pull 을 하여 상태를 동일하게 맞춘다.
 - branch를 만든다.
 - 오늘의 코드를 작성하면서 세분화하여 git 을 새로 만든 branch 에 저장해 둔다.
 - 해당 작성이 모두 완료되면 branch 를 main branch 에 머지한다.