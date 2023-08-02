# DynamicUI

기획 문서 : [https://www.notion.so/Dynamic-UI-Project-Document-23b78abe83114f5b94bb17985eddb01f](https://oyunseong.notion.site/Dynamic-UI-Project-Document-23b78abe83114f5b94bb17985eddb01f?pvs=4)

## 앱 실행 화면 : 

<img src="https://user-images.githubusercontent.com/42116216/211138970-0e5cac08-57ea-4caf-a3e0-45fe7033e3b7.jpg" width="300" height="533.33"/> <img src="https://user-images.githubusercontent.com/42116216/211138972-3344ceaa-43ea-493b-8862-11f8b77c75c8.jpg" width="300" height="533.33"/> <img src="https://user-images.githubusercontent.com/42116216/211296144-0fc8ee46-2a04-4a86-a831-b4fd15f021ce.gif" width="300" height="533.33"/>

---
### 기획
<img src="https://github.com/oyunseong/DynamicUI/assets/42116216/8fd76742-ea3c-46aa-b536-8e5b79ece1da" width="300" height="533.33"/> <img src="https://github.com/oyunseong/DynamicUI/assets/42116216/38dd5e17-94f2-4a99-a165-67b613162c93" width="300" height="533.33"/> <img src="https://github.com/oyunseong/DynamicUI/assets/42116216/982f999a-2734-4083-b89b-b068bb5697ac" width="300" height="533.33"/> 


# 배경 정보 & 조사 내용


---

Multi ViewHoder를 사용하는 앱

1. Netflix
2. G마켓 
3. 네이버 쇼핑 라이브

<img src="https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8762a510-300d-40e1-8df3-4621586d72e2/Untitled.png" width="300" height="533.33"/> <img src="https://user-images.githubusercontent.com/42116216/211138972-3344ceaa-43ea-493b-8862-11f8b77c75c8.jpg" width="300" height="533.33"/>

<img src="https://github.com/oyunseong/DynamicUI/assets/42116216/a11c3be6-11a3-41b3-add4-1fc19eba19b8" width="300" height="533.33"/> 
![1](https://github.com/oyunseong/DynamicUI/assets/42116216/a11c3be6-11a3-41b3-add4-1fc19eba19b8)
![2](https://github.com/oyunseong/DynamicUI/assets/42116216/95444632-1562-41e6-bb61-3dec7b8d80c6)
![3](https://github.com/oyunseong/DynamicUI/assets/42116216/b195f459-ea87-4e69-938d-a31a0172d0c3)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0a25b027-0f03-49bc-a692-78f0d124ca4a/Untitled.png)

# 왜?

---

### 백엔드 서버에서 내려주는 다양한 타입 적용

- 운영에서 앱의 UI 및 컨텐츠를 동적으로 구성할 수 있도록 하기 위함
    1. 웹 어드민에서 뷰타입 및 컨텐츠 설정
    2. 서버에 반영
    3. 클라이언트에서는 운영에서 설정한대로 UI가 보여지도록 구현

# 어떻게?

---

- Multi ViewHolder를 이용해 다양한 타입의 recyclerview item type을 보여줌
- 총 2가지의 버전으로 UI 제작 진행 예정
    1. XML
    2. Android Compose

사용 예정 기술 스텍 : Android Jetpack, Databinding, Coroutine, MVVM 등

사용 라이브러리 : ExoPlayer

# 필수 요구사항
---


- 사전 조사한 앱 Home UI와 비슷하게 제작
- 서버에서 내려주는 정보에 맞춰서 뷰 순서 및 컨텐츠가 배치되도록 구현
- View Type은 최소 4~5개
- Compose와 Xml로 UI를 제작해도 ViewModel은 항상 변하지 않도록 코드 작성
- Icon은 컬러로 설정할 수 있도록 구현
- View Type 중 동영상 재생이 가능한 Video Player View 추가

# 성공 지표

---

1. 유연하게 타입 변경이 가능한 RecyclerView 구현
2. UI를 그리는 방식이 달라져도 동일한 ViewModel Class 사용
