import csv
import shutil
import os

st = 's001'

file = './dataset_rt-bene/csvs'
dir0 = '/zero'
dir1 ='/one'
exce = '/'+st + '_blink_labels'

csv_an = '.csv'
csv_file = file + exce + csv_an

one_file = file + dir1 + exce + '1'  + csv_an
zero_file = file + dir0 + exce +'0' + csv_an

f0 = open(zero_file, 'r')
r0 = csv.reader(f0)

dir = r'C:\Users\mlpa\Desktop\capston_drowsiness_detection_MLPA\dataset_rt-bene\\'+st+r'_noglasses\natural'
condir = dir + '/concat'
zerodir  = dir + '/zero'
onedir = dir + '/one'

os.mkdir(zerodir)
os.mkdir(onedir)


for line in r0 :
    shutil.move(condir + '/'+line[0], zerodir)

f1 = open(one_file, 'r')
r1 = csv.reader(f1)

for line in r1 :
    shutil.move(condir + '/' + line[0], onedir)


f0.close()