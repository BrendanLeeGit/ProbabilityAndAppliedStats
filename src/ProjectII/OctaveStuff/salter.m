clear all
fclose all

%change this according to the csv file
xRange = 49;
saltValue = 50;

%open up file and read contents
outputCSV = fopen("output.csv", 'r');
A = fscanf(outputCSV, '%f, %f', [2 xRange]);
B = A';
fclose(outputCSV);

%salt the data before graphing
for i = 1:xRange
  randomNumber = randi([-saltValue, saltValue]);
  B(i, 2) = B(i,2) + randomNumber;
end

x = B(:,1);
y = B(:,2);

plot(x, y);
xlabel('x');
ylabel('y');
grid on

%copy data to csv for the smoother
saltedDataCSV = fopen("salteddata.csv", "w");
fprintf(saltedDataCSV, "%f, %f\n", B');
fclose(saltedDataCSV);





