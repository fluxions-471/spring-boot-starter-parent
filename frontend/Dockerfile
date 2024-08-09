FROM node:22 AS build

WORKDIR /app
COPY package*.json ./
RUN npm install
RUN npm update
COPY . .
RUN npm run build

FROM nginx:alpine
COPY --from=build /app/dist/frontend/browser /usr/share/nginx/html
