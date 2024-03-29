# PostMan

## postman 사용법

## **스크립트 예시**

**특징**

- Pre-script, Test 모두 Javascript를 언어로 사용한다.
- request의 위치가 `Root Colletion/Sub Collection/request` 인 경우, 스크립트는 `Root Colletion`, `Sub Collection`, `request`의 순서대로 실행된다.

## Script 공통

- get

```jsx
pm.environment.get("variable_key");     // 환경 변수에 저장
pm.globals.get("variable_key");         // 전역 변수로 저장
pm.variables.get("variable_key");       // 해당 일련의 request에 사용되는 변수, 즉 일련의 request면 다음번 reuquest에서도 사용 가능
pm.collectionVariables.get("variable_key");     // 해닻 collection에서 사용되는 변수
```

- set

```jsx
// 저장
pm.environment.set("variable_key", "value");     // 환경 변수에 저장
pm.globals.set("variable_key", "value");         // 전역 변수로 저장
pm.variables.set("variable_key", "value");       // 해당 일련의 request에 사용되는 변수, 즉 일련의 request면 다음번 reuquest에서도 사용 가능
pm.collectionVariables.set("variable_key", "value");     // 해닻 collection에서 사용되는 변수

// 삭제
pm.environment.unset("variable_key");
pm.globals.unset("variable_key");
pm.variables.unset("variable_key");
pm.collectionVariables.unset("variable_key");
```

- 날짜 저장

```jsx
today = new Date();
today = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + today.getDate()).slice(-2);
// 2022-01-01
```

### **Test**

- 기본 테스트

```jsx
// request가 일단 제대로 전달되었는지 여부
pm.test("Successful POST request", function () {
    pm.expect(pm.response.code).to.be.oneOf([200, 201, 202]);
});

// request가 성공했는지 체크
pm.test("Status code is 200y", function () {
    pm.response.to.be.ok;
});

// request가 body가 있는지 체크
pm.test("response must be with Body", function () {
    pm.response.to.be.withBody;
});

// request가 json 형태인지 체크
pm.test("response must be json", function () {
    pm.response.to.be.json;
});

// reqest가 error인지 체크
pm.test("response should be okay to process", function () {
	  pm.response.to.not.be.error;
});
```

- 상태 코드

```jsx
// status code 201 은 Created 이므로 같은 결과 반환
pm.test("Status code is 200", () => {
  pm.response.to.have.status(200);
});

pm.test("Status code name has string", () => {
  pm.response.to.have.status("OK");
});

// status code 201 은 Created 이므로 같은 코드
pm.test("Status code is 201", () => {
  pm.response.to.have.status(201);
});

pm.test("Status code name has string", () => {
  pm.response.to.have.status("Created");
});
```

- 헤더 값 확인

```jsx
pm.test("Content-Type header is present", () => {
  pm.response.to.have.header("Content-Type");
});

pm.test("Content-Type header is application/json", () => {
  pm.expect(pm.response.headers.get('Content-Type')).to.eql('application/json');
});
```

- 헤더 안의 쿠키 값 확인

```jsx
// 쿠키 안에 JSESSIONID 가 있는지 확인
pm.test("Cookie JSESSIONID is present", () => {
  pm.expect(pm.cookies.has('JSESSIONID')).to.be.true;
});

// isLoggedIn 값이 1인지 확인
pm.test("Cookie isLoggedIn has value 1", () => {
  pm.expect(pm.cookies.get('isLoggedIn')).to.eql('1');
});
```

- response 의 타입 확인 방법

```jsx
/* response has this structure:
{
  "name": "Jane",
  "age": 29,
  "hobbies": [
    "skating",
    "painting"
  ],
  "email": null
}
*/
const jsonData = pm.response.json();
pm.test("Test data type of the response", () => {
  pm.expect(jsonData).to.be.an("object");
  pm.expect(jsonData.name).to.be.a("string");
  pm.expect(jsonData.age).to.be.a("number");
  pm.expect(jsonData.hobbies).to.be.an("array");
  pm.expect(jsonData.website).to.be.undefined;
  pm.expect(jsonData.email).to.be.null;
});

/*
response has this structure:
{
  "errors": [],
  "areas": [ "goods", "services" ],
  "settings": [
    {
      "type": "notification",
      "detail": [ "email", "sms" ]
    },
    {
      "type": "visual",
      "detail": [ "light", "large" ]
    }
  ]
}
*/

const jsonData = pm.response.json();
pm.test("Test array properties", () => {
    //errors array is empty
  pm.expect(jsonData.errors).to.be.empty;
    //areas includes "goods"
  pm.expect(jsonData.areas).to.include("goods");
    //get the notification settings object
  const notificationSettings = jsonData.settings.find
      (m => m.type === "notification");
  pm.expect(notificationSettings)
    .to.be.an("object", "Could not find the setting");
    //detail array must include "sms"
  pm.expect(notificationSettings.detail).to.include("sms");
    //detail array must include all listed
  pm.expect(notificationSettings.detail)
    .to.have.members(["email", "sms"]);
});
```

- Json 안에 data 가 있는지 확인

```jsx
pm.test("Body is correct", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData).to.have.property('data');
});
```

- data status 값이 있는지 확인

```jsx
pm.test("status is have", function () {
    pm.expect(pm.response.json().data).to.have.property('status');
});
```

- result의 값이 `SUCCESS` 인지 확인

```jsx
pm.test("status is SUCCESS", function () {
    pm.expect(pm.response.json().result.status).to.equal("SUCCESS");
});
```

- 해당 값이 배열중에 하나의 값인지 확인

```jsx
pm.test("Successful POST request", () => {
  pm.expect(pm.response.code).to.be.oneOf([201,202]);
});
```

- Body 안에 특정 문자열 있는지 확인

```jsx
pm.test("Body contains string",() => {
	// pm.response.text() // 응답을 text로 변경, 만약 JSON이면 텍스트 형태가 된다.
  pm.expect(pm.response.text()).to.include("customer_id");
});
```

- Body 값 확인

```jsx
pm.test("Test data type of the response", () => {
	// a,b 둘 다 있는지 확인, 하나라고 없으면 false
	pm.expect({a: 1, b: 2}).to.have.all.keys('a', 'b');
	// a,b 하나도 있는지 확인, 하나라도 있으면 True
	pm.expect({a: 1, b: 2}).to.have.any.keys('a', 'b');
	// a,b 둘 다 없는지 확인, 하나라도 있으면 False
	pm.expect({a: 1, b: 2}).to.not.have.any.keys('c', 'd');
	// a,b 하나라도 있는지 확인, 둘다 없어야 True
	pm.expect({a: 1, b: 2}).to.not.have.all.keys('a', 'd');
	// a가 key 로 있는지 확인
	pm.expect({a: 1}).to.have.property('a');
	// Object 형태인지 확인하고, 키로 a,b 가 포함되어 잇는지 확인
	pm.expect({a: 1, b: 2}).to.be.an('object').that.has.all.keys('a', 'b');
});
```

- 다음 요청 설정하기

![스크린샷 2022-09-17 오후 11.15.30.png](https://user-images.githubusercontent.com/50443940/190863132-aef290ca-eca7-4de3-9460-787f1b60467c.png)

다음 요청하고 싶은 요청의 이름이 `다음 요청` 이고, ID가 `13774241-b53ea3d5-00bd-46a1-b089-418ef3cab5ef` 인 경우 요청 방법

```jsx
// 요청의 2가지 방법
postman.setNextRequest("다음 요청");    // 요청의 request 이름을 그대로 사용
postman.setNextRequest("b53ea3d5-00bd-46a1-b089-418ef3cab5ef");   // 요청ID에서 가장 앞을 제거하고 나머지 설정
```

만약 이 요청을 마지막으로 종료하고 싶은 경우

```jsx
postman.setNextRequest(null);
```

- 요청 호출 및 저장하기

```jsx
do {
    flag = false
    pm.sendRequest(pm.collectionVariables.get("job-progress"),
        function (err, response) {
            if (response.status == "OK") {
                // Success script
            }
            else {
                // Fail script
            }
        });
} while (flag)
```

- 다른 방식으로 요청

```jsx
pm.sendRequest({
    url: `${hostURL}/test`,
    method: 'POST',
    header: {
        "Content-Type": "application/json",
    },
}, function (err, response) {
    var jsonData = response.json();
    if (jsonData.access_token) {
        // success script
    }
});
```

- Body set

```jsx
today = new Date(); 
start_Date = new Date(today.getFullYear(), today.getMonth(), today.getDate() - 7)

body = {
    mode: 'raw',
    raw: JSON.stringify({
        "fromDate": today.getFullYear()+ ('0' + (today.getMonth() + 1)).slice(-2) + ('0' + today.getDate()).slice(-2),
        "toDate": start_Date.getFullYear()+ ('0' + (start_Date.getMonth() + 1)).slice(-2) + ('0' + start_Date.getDate()).slice(-2),
    }),
    options: {
        raw: {
            language: 'json'
        }
    }
}
pm.request.body.update(body);
```

## 참고

https://learning.postman.com/docs/writing-scripts/script-references/postman-sandbox-api-reference/