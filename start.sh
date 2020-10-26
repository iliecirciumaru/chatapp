#!/bin/bash


cd backend &&
docker build -t chat-backend  . &&

cd ../frontend &&
docker build -t chat-frontend . &&

cd ../ &&
docker-compose up -d

