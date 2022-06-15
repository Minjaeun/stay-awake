'''
1. 모델에 사진을 넣고 눈 감았는지 떴는지 확인
- 얼굴 전체 사진 넣고 opencv로 눈 부분만 crop해서 자동으로 모델 결과 얻어오기
2. 실시간으로 들어오는 영상을 프레임별로 쪼개서  사진 + 결과 얻기
3. 프레임을 모델에 집어넣은 결과 값이 closed가 수 초 이상 검출되면 잔다고 판단.
'''


import numpy as np
import cv2
from PIL import Image
import matplotlib.pyplot as plt


def get_positions_at_frame(frame):
    face_cascade = cv2.CascadeClassifier('./haarcascade_frontalface_default.xml')
    eye_cascade = cv2.CascadeClassifier('./haarcascade_eye.xml')

    image = frame

    gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    face = face_cascade.detectMultiScale(gray, 1.3, 5)
    eyes = ()
    for (x, y, w, h) in face:
        roi_gray = gray[y:y + w, x:x + w]
        # roi_color = image[y:y + h, x:x + w]
        eyes = eye_cascade.detectMultiScale(roi_gray, 1.3, 5)

    if face == ():
        face = [[0, 0, 0, 0]]
    if eyes == ():
        eyes = [[0, 0, 0, 0], [0, 0, 0, 0]]
    return (face[0], eyes)


def get_eye_position(eyes_position,face):
    first_eye = eyes_position[0]
    second_eye = eyes_position[1]
    start = [min(first_eye[0],second_eye[0]) ,min(first_eye[1],second_eye[1])]
    finish = [ max( first_eye[0] + first_eye[2], second_eye[0] + second_eye[2] ), max(first_eye[1] + first_eye[3],second_eye[1] + second_eye[3])]
    eye_position = (start[0] + face[0], start[1] + face[1], finish[0] + face[0], finish[1] + face[1])

    return eye_position

def frame_crop(frame, face, eyes):
    x1, y1, x2, y2 = get_eye_position(eyes, face)
    # print(eye_position)

    cropped_eye = frame[y1:y2, x1:x2]
    return cropped_eye

def model_loading(model_name):
    import warnings
    warnings.simplefilter(action='ignore', category=FutureWarning)
    # % matplotlib inline

    from keras.models import load_model
    model = load_model(model_name)
    return model

def frame_model_predicting(frame, model):

    # img = frame.resize((85, 23))
    img = cv2.resize(frame, (23, 85))
    x = img_to_array(img)
    x = np.expand_dims(x, axis=0)
    images = np.vstack([x])

    classes = model.predict(images, batch_size = 10)
    #     print(classes)
    print(classes[0])
    #     print('classes : ', classes)

    if classes[0, 0] < 1:
        print("closed")
    else:
        print("open")
    return classes[0]



from tensorflow.keras.preprocessing.image import array_to_img

#load the model

model_path = './weight_balancing_model_final.h5'
model = model_loading(model_path)
cls_index = ['open', 'closed']

# 노트북 카메라에서 실시간으로 영상을 읽어온다
cap = cv2.VideoCapture(0)

#테스트용 영상 입력
#filename = './KakaoTalk_20220615_105114380.mp4'
#cap = cv2.VideoCapture(filename)

i = 0
while (True):
    # frame 별로 capture 한다
    ret, frame = cap.read()

    # 좌우 반전은 1, 상하반전은 0
    frame = cv2.flip(frame, 1)
    # webCamera라는 이름으로 실시간 화면을 보여준다.
    cv2.imshow('webCamera', frame)
    # q를 누르면 종료되도록 하는 코드이다.
    if cv2.waitKey(1) == ord('q'):
        break
    # 프레임이 제대로 읽어지지 않은 경우
    if not ret:
        print("Can't receive frame (stream end?). Exiting ...")
        break
    # crop the eyes
    face, eyes = get_positions_at_frame(frame)
    if all(0 == f for f in face):
        continue
    if all(0 == e for e in np.ravel(eyes)):
        continue
    if eyes.shape == (1, 4):
        continue
    eye_frame = frame_crop(frame, face, eyes)
    arr = cv2.resize(eye_frame, (85, 23 ))
    result = model.predict(arr.reshape(1, 85, 23, 3))
    #result = frame_model_predicting(eye_frame, model)
    print('result : ' , result)
    if result[0][1] < 1 :
        category = cls_index[1]
    else:
        category = cls_index[0]
    print(i, 'th category : ', category)
    i = i+1
    # 빨간 사각형으로 인식된 눈을 표시한다.


# 메모리를 해제시켜준다.
cap.release()
cv2.destroyAllWindows()