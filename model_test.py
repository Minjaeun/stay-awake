import warnings
warnings.simplefilter(action = 'ignore', category = FutureWarning)

import sys
import os
import tensorflow as tf
import keras
import matplotlib.pyplot as plt
import numpy as np
from keras.preprocessing import image
from keras.models import load_model

from tensorflow.keras.preprocessing.image import array_to_img
import numpy as np
import tensorflow as tf
import os
import cv2
import matplotlib.pyplot as plt
from tensorflow.keras.preprocessing.image import ImageDataGenerator

model = load_model('weight_balancing_model_final.h5')
imageGenerator = ImageDataGenerator(
    rescale=1./255,
    horizontal_flip=True,
    validation_split=.1
)

img_dir_path = r'C:\Users\mlpa\jynb\onc'
testGen = imageGenerator.flow_from_directory(
    img_dir_path,
    target_size=(85, 23)
)

cls_index = ['open', 'closed']
imgs = testGen.next()
while(imgs):
    arr = imgs[0][0]
    img = array_to_img(arr).resize((85, 23))
    plt.imshow(img)

    result = model.predict(arr.reshape(1, 85, 23, 3))
    if result[0][1] < 1 :
        category = cls_index[1]
    else :
        category = cls_index[0]

    #print('result : ', result)
    print('category is : ', category)
    plt.show()
    imgs = testGen.next()