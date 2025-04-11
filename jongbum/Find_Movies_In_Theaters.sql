SELECT
	theater.name AS 영화관,
    movie.name AS 영화_이름
FROM
	theater
JOIN
	movie
ON
	theater.theater_id = movie.theater_id;