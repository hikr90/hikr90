// 받는 쪽에서도 대괄호를 사용하여 user-1에서 내보낸 두가지의 변수를 가져온다.
const { user1, user2 } = require("./users-1");
const hello = require("./hello");

hello(user1);
hello(user2);
