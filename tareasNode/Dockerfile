FROM node:22.1.0
WORKDIR /src

COPY package*.json ./
RUN npm install
COPY . .

EXPOSE 3000
CMD ["node", "./src/app.js"]