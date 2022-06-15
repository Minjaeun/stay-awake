import csv

file = './dataset_rt-bene/csvs'
dir0 = '/zero'
dir1 ='/one'
exce = '/s016_blink_labels'

csv_an = '.csv'
csv_file = file + exce + csv_an



one_file = file + dir1 + exce + '1'  + csv_an
zero_file = file + dir0 + exce +'0' + csv_an

f = open(csv_file, 'r')
rdr = csv.reader(f)

f1 = open(one_file, 'a', newline = '')
f0 = open(zero_file, 'a', newline = '')
wr1 = csv.writer(f1)
wr0 = csv.writer(f0)

for line in rdr :
    if float(line[1]) == 1.0 :
        wr1.writerows([line])
    elif float(line[1]) == 0.0 :
        wr0.writerows([line])

f.close()
f1.close()
f0.close()