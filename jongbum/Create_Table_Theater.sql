USE jongbum;

DROP TABLE theater;
CREATE TABLE theater(
	theater_id INTEGER PRIMARY KEY,	-- 극장의 고유 ID
    name VARCHAR(10) UNIQUE,		-- 극장의 이름이 중복되면 안 되기 때문에 UNIQUE 사용
    count INTEGER					-- 극장에서 상영하는 영화 개수
);