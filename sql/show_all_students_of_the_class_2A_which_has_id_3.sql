SELECT student_id, name, surname, email
    FROM enrollment
	JOIN students on FK_student_id = student_id
	WHERE FK_course_id = 3;