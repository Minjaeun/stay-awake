import shutil
import os

zero_dir = r'C:\Users\mlpa\Desktop\capston_drowsiness_detection_MLPA\dataset_rt-bene\dataset\open'
one_dir = r'C:\Users\mlpa\Desktop\capston_drowsiness_detection_MLPA\dataset_rt-bene\dataset\closed'

#
# z_d = os.listdir(zero_dir)
# for d in z_d :
#     img = os.listdir(zero_dir + '/' + d)
#     for i in img :
#         os.rename(zero_dir + '/' + d + '/' + i, zero_dir + '/' + d + '/' + d+ '_' + i )
#         shutil.move(zero_dir + '/' + d + '/' + d+ '_' + i , zero_dir)

o_d = os.listdir(one_dir)
for d in o_d :
    img = os.listdir(one_dir + '/' + d)
    for i in img :
        os.rename(one_dir + '/' + d + '/' + i, one_dir + '/' + d + '/' + d+ '_' + i )
        shutil.move(one_dir + '/' + d + '/' + d+ '_' + i , one_dir)