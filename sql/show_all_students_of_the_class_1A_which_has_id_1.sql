SELECT student_id, name, surname
    FROM enrollment
	JOIN students on FK_student_id = student_id
	WHERE FK_course_id = 1;