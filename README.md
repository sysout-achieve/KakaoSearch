# KakaoSearch


### <h2>과제 수행 전략</h2> 
1.	제대로 동작하는 프로그램
2.	의존성을 최대한 줄일 것
3.	알고 사용할 것

가장 먼저 요구사항을 충족하는 프로그램을 만드는 것을 최우선으로 정했습니다. 
지정해준 요구사항에 맞는 프로그램을 만드는 것이 가장 기본적인 채점 기준이라 생각했습니다.

요구사항 속 두 개의 fragment 구성은 Context사용과 Model layer와 View layer를 명확하게 구분지어
프로그래밍하기 어려울 것이라 판단했습니다. 복잡한 설계일수록 의존성을 줄여 각 객체들이 각자의 역할을 충실히
수행하게 만드는 것이 중요하다 생각했습니다.

Kotlin을 처음 사용하면서 모르는 연산자와 선언 등으로 어려움이 많았습니다. 
멋스러운 코드 대신 알고 사용하자는 마음가짐으로 과제를 수행했습니다.


### <h2>과제 수행 방법</h2>

Test안에서 간단한 코드들을 쳐보며 Kotlin을 익혀 나갔습니다. 

첫번째 fragment(도서 검색 화면)
-	검색하는 검색 화면과 검색한 결과가 다른 클래스에서 출력돼야 했습니다.
Activity는 fragment를 add하기 위해 fragment를 저장 공간에 가지고 있어야 했습니다. 
반대로 fragment와 adapter에 activity의 의존성을 주입하면 더 쉬운 구현을 했을 수 있지만 
상호참조의 위험성 context 의존성 주입은 GC가 수거해가지 못하는 안티패턴임을 알고 최대한 의존성 
주입을 피하며 작업했습니다.

두번째 fragment(도서 상세 화면)
-	도서 상세 화면 역시 fragment로 만들어져야 하기 때문에 기존에 있는 액티비티에서
fragment를 호출할 때 필요한 정보를 가지고 있습니다. Adapter의 아이템클릭리스너에 넘어가야할 
정보를 묶어서 도서 검색 리스트 화면으로 보냈습니다. Fragment내에서 간편하게 아이템 정보를 가져와 
다음 화면으로 넘길 수 있게 만들었습니다.


아쉬움이 많이 남는 과제였습니다. “회사를 안 다녔으면 좋았을텐데… kotlin도 좀 봐두면 좋았을텐데…” 하는 생각이 
계속 머리에서 맴돌았습니다. 그러나 이번 기회를 통해서 초고속으로 kotlin을 사용해보았고, 아직 낯설긴 하지만 
무섭지 않은 언어가 되었습니다. 



<hr>

OpenSources<br>
Glide - https://github.com/bumptech/glide <br>
Retrofit - https://github.com/square/retrofit<br>
Timber - https://github.com/JakeWharton/timber<br>
Junit - https://github.com/junit-team<br>



