x = linspace(0, 2*pi, 100);
y = sin(x);
plot(x, y);

x = 4
for i = 4:32
  x = x + 14;
 end
disp(x);

%NOTE!!!
%ARRAYS START AT 1, NOT 0

%random number generation method?
%randi
randomNumber = randi([-200, 200]);
disp(randomNumber);

for i = 1: 30
  rando = randi([-40, 40]);
  disp(rando);
end



%following along with Mr. Stem Edu TV's video
clear all, fclose all
fid = fopen('test1.csv', 'r');
A = fscanf(fid, '%f %f', [2 11]) %no semi colon needed??
B = A'
fclose(fid); %not closing files causes problems

x = B(:,1);
y = B(:,2);

plot(x, y);

%dont know why but this part gives me random issues
set(gca, 'linewidth', 1, 'fontsize', 36)

xlabel('x');
ylabel('y');
grid on

%printing to csv
fid = fopen('test2.csv', 'w'); %w indicates writing not reading
A = B';
fprintf(fid, '%f, %f\n', A);
fclose(fid);



