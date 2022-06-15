import cv2
import os

import matplotlib.pyplot as plt

eyepath = r'C:\Users\mlpa\Desktop\capston_drowsiness_detection_MLPA\dataset_rt-bene\s001_noglasses\natural'
Leyepath = eyepath + '/left'
Reyepath = eyepath + '/right'

Leyes = os.listdir(Leyepath)
Reyes = os.listdir(Reyepath)
os.mkdir(eyepath+'/concat')
# print(Leyes[0])
for i in range( len(Leyes) ):
# for i in range( 10 ):

    R = Reyes[i]
    L = Leyes[i]

    Leye = cv2.imread(Leyepath + '/'+ L)
    Reye = cv2.imread(Reyepath + '/'+ R)

    # print(Leyepath + '/'+ Leyes[i])
    # print(Reyepath + '/'+ Reyes[i])

    im = cv2.hconcat([Reye, Leye])
    print(eyepath+'/concat/'+L)
    cv2.imwrite(eyepath+'/concat/'+L, im)
