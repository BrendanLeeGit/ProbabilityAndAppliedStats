clear all
fclose all

%change this according to the csv file and preferences
xRange = 49;
smoothRange = 8;
smoothCount = 4;

%open up file and read contents
saltedDataFile = fopen("salteddata.csv", 'r');
A = fscanf(saltedDataFile, '%f, %f', [2 xRange]);
B = A';
fclose(saltedDataFile);

x = B(:,1);
y = B(:,2);

smoothy = y;

%smooth data before plotting, but only the y of course with movmean
for i = 1:smoothCount
  smoothy = movmean(smoothy, smoothRange);
end

%once it's smoothed, set the B back to the smoothy, else the csv doesn't work
B(:,2) = smoothy;

plot(x, smoothy);
xlabel('x');
ylabel('y');
grid on

smoothedDataFile = fopen("smootheddata.csv", "w");
fprintf(smoothedDataFile, "%f, %f\n", B');
fclose(smoothedDataFile);




