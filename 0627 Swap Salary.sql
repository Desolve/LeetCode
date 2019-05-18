# Write your MySQL query statement below
# 211 = ascii('f') + ascii('m')
update salary set sex = char(211-ascii(sex))