DROP TABLE  HR.EMP_TEST
CREATE TABLE HR.EMP_TEST (
    NAME CHAR(50)
);
INSERT INTO HR.EMP_TEST(NAME)
VALUES ('  Ahmed');

INSERT INTO HR.EMP_TEST(NAME)
VALUES ('Ahmed   ');
-- يشيل من الجوانب
SELECT  TRIM(BOTH ' ' FROM ' Ahmed ');
-- يشيل من البداية(اليمين 
SELECT  TRIM(LEADING ' ' FROM ' Ahmed ');
--اليسار )ليشيل من النهاية
SELECT  TRIM(TRAILING ' ' FROM ' Ahmed ');

SELECT 
  LTRIM('   EMAD   ') AS left_trim,--بتشيل من طرف واحد وهو اليسار ويمكن تشيل اكثر من حرف مو مسافات فقط
  RTRIM('   EMAD   ') AS right_trim,--كذالك دى بس من اليمين 
  TRIM('   EMAD   ')  AS both_trim --انما دى تشيل من الطرفين عادى بس حرف واحد فقط 
FROM dual;

SELECT TRIM(BOTH '*' FROM '*MY PASSWORD#6*')AS RESULT FROM dual;

SELECT TRIM(BOTH '#' FROM '##HELLO WORLD##')AS RESULT FROM dual;



