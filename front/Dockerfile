# Stage 1 - the build process
FROM node:10.15.3 as build-deps
LABEL Author="Jorge Ortega"
USER root
# Versions
RUN npm -v
RUN node -v
RUN cat /etc/issue
RUN chmod -R 766 /var/log/nginx/

WORKDIR /usr/src/app
COPY ./package.json ./
COPY . ./
RUN npm install
RUN npm i react-scripts@4.0.0
RUN npm run build

# Stage 2 - the production environment
## FROM nginx:1.12-alpine
FROM nginxinc/nginx-unprivileged 
COPY --from=build-deps /usr/src/app/build /usr/share/nginx/html
EXPOSE 3000
CMD ["nginx", "-g", "daemon off;"]