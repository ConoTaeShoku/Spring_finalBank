-- 회원관련 table
CREATE TABLE sb_customer
(
	custid varchar2(20) primary key,
	password varchar2(20) not null,
	name varchar2(20) not null,
	email varchar2(30),
	division varchar2(30),
	-- 개인 : 'personal', 기업 : 'company'
		-- check : 두 개의 값만 가능
		-- default : 하나의 값
	idno varchar2(20) unique,
	-- 식별번호: (개인 : 주민번호, 기업 : 사업자번호)
	address varchar2(100),
	
	constraint sb_customer_check check (division in ('personal','company'))
);

--잊어버렸다면
ALTER TABLE sb_customer
ADD CONSTRAINT sb_customer_check
CHECK (division IN ('personal', 'company'));

-- 게시판 테이블
CREATE TABLE sb_board
(
	boardnum number primary key,
		-- number(3) : 정수 3자리, 999까지
		-- number(5,2) : 전체 자리 수 5자리, 소숫점 2자리까지
		-- number : 22자리
		-- 모두 음수가 들어갈 수 있음
		-- java integer은 32bit = 4byte
	custid varchar2(20) not null,
	title varchar2(100) not null,
	content varchar2(2000) not null,
	inputdate date default sysdate,
	hits number default 0,
	originalfile varchar2(200),
	-- 첨부파일(원래이름)
	savedfile varchar2(200)
	-- 첨부파일(실제 저장된 이름)
		--file혹은 그림을 server에 저장할 때, 사용자가 올리는 이름을 바꾸어 중복시 처리함
);

-- 게시판 시퀀스
create sequence sb_board_seq
[start with 1 increment by 1];
-- 생략가능한 것은 대괄호로

-- 댓글 테이블
CREATE TABLE sb_reply
(
	replynum number primary key, -- constraint reply_num_pk primary key : 옆에 적을 수 있음
	boardnum number not null,
	custid varchar2(20) not null,
	text varchar2(200) not null,
	inputdate date default sysdate,

	constraint sb_reply_fk foreign key(boardnum) -- 우리 쪽 테이블
	references sb_board(boardnum) -- 보드 테이블에 연관되어있어 이를 참조
-- 옆으로 주는 것이 아니라, 아래에 몰아서 constraint를 부여

-- 관계형 테이블의 관계는 foreign key가 만듦
-- 부모에 데이터가 있어야 자식에게 있음
-- 무결성 보장하는 것이 중요

-- 제약 조건에 이름을 주는 것은 관리하기 편하기 위해
-- meta table : 만들어진 정보를 관리하기 위한 "시스템" 쪽의 테이블
-- 이름을 부여하지 않으면 시스템 자체로 이름을 붙히기 때문에 (SYS~~~) 어느 테이블의 어느 칼럼에 걸린 constraint인지 빨리 파악하기 어려움

	on delete cascade
);

-- 댓글 시퀀스
create sequence sb_reply_seq