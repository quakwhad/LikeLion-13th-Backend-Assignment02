USE jongbum;

CREATE TABLE movie(
	movie_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL, -- 영화의 이름이 없는 경우는 없기 때문에 NOT NULL로 지정
    theater_id INTEGER,
    FOREIGN KEY (theater_id) REFERENCES theater(theater_id)
);