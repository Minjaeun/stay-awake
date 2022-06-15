import shutil
import os

zero_dir = r'C:\Users\mlpa\Desktop\capston_drowsiness_detection_MLPA\dataset_rt-bene\dataset\train\open'
one_dir = r'C:\Users\mlpa\Desktop\capston_drowsiness_detection_MLPA\dataset_rt-bene\dataset\train\closed'
zero_test_dir = r'C:\Users\mlpa\Desktop\capston_drowsiness_detection_MLPA\dataset_rt-bene\dataset\test\open'
one_test_dir = r'C:\Users\mlpa\Desktop\capston_drowsiness_detection_MLPA\dataset_rt-bene\dataset\test\closed'


img = os.listdir(one_dir)
for i in range(len(img)) :
    if ( i % 11 == 0):
        shutil.move(one_dir + '/' + img[i], one_test_dir)


