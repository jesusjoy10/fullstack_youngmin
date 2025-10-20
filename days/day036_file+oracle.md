# Github - revert / reset
1. revert - 안전한 취소 - 깃허브 [공용]
2. reset - 아예 지워버리기 - [혼자] 브랜치에서 

실습(1) revert
1. 본인브랜치에서 파일작성  - test브랜치에서 새작업하고 원격저장소에 푸쉬
```bash
git branch
git checkout 테스트브랜치명
파일작성 rever.md
git add.
git commit -m "revert"
git push origin 테스트브랜치명 
```
2. main 브랜치에 병합 - test브랜치작업을 main 병합하고 푸시 (merge)
```bash
git checkout master
git pull origin master
git merge 테스트브랜치명
git push origin master

```

2. main 브랜치에서 병합
