# Kakaopay_TaeSungKim
카카오과제...

  * com.kakao.pay.exception
    * URLShortenerException
  * com.kakao.pay.shortening
    * DemoApplication
    * ShortenerConfig
  * com.kakao.pay.shortening.controller
    * ShortenerController
  * com.kakao.pay.shortening.service
    * ShortenerManager
    * ShortenerManagerImpl
  * com.kakao.pay.shotening.shortener
    * BaseURLShortener
    * RandomURLShortener
    * URLShortener
  * com.kakao.pay.shortening.store
    * ShortenerStoreImpl
    * UrlKeyValueStore
    
ShortenerConfig에서 기본 도메인과 ShorteningURL길이와 Shortening방식을 읽고<br>
Shorteing값에 따라 RandomURLShortener와 URLShortener 결정된다.<br>
RandomURLShortener는 지정된 길이로 랜덤으로 URL을 만들어 주고<br>
URLShortener는 1부터 순차적으로 62진수로 계산이 된다.<br>
모든 행위는 ShortenerManagerImpl을 통하여 시작이 되며<br>
등록된 URL은 ShortenerStoreImpl에 Map형식으로 저장이 된다.<br>
등록과정에 유효성 검사를 통하여 등록하고자 하는 URL의 값이 정상인지 비정상인지 판단은 <br>
앞에 프로토콜이 http:// 혹은 https:// 에 한에서 정상으로 판단한다.<br>
(들어온 URL이 정상인지 판단하기 위해 URL호출 후 결과값을 받기엔 부담이 될꺼 같아 간소화함)<br>
