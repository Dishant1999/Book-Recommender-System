# function to read csv files
loadLibraries <- function() {
  library(dplyr)#to manipulate dataset , written in c++, uses small interfaces
  library(tidyr)#each value is column and observation is row
  library(Matrix)
  library(recommenderlab)
}
readBooks <- function() {
  df_books <- read.csv(
    file = "E:/Book Recommender Script R/Processed/processed_books.csv",
    header = TRUE,
    sep = ",",
    quote = "\""
  )
  return(df_books)
}
readRatings <- function() {
  df_ratings <- read.csv(
    file = "E:/Book Recommender Script R/Processed/processed_ratings.csv",
    header = TRUE,
    sep = ",",
    quote = "\""
  )
  return(df_ratings)
}
readUsers <- function() {
  df_users <- read.csv(
    file = "E:/Book Recommender Script R/Processed/processed_users.csv",
    header = TRUE,
    sep = ",",
    quote = "\""
  )
  return(df_users)
}
# create sparse of rating matrix
getSparseMatrix <- function(variables) {
  
  df_books <- readBooks()
  df_ratings <- readRatings()
  df_users <- readUsers()
  
  dimension_names <- list(user_id = sort(unique(df_ratings$user_id)), book_id = sort(unique(df_ratings$book_id)))
  
  ratingmat <- spread(select(df_ratings, book_id, user_id, rating), book_id, rating) %>% select(-user_id)
  
  ratingmat <- as.matrix(ratingmat)
  dimnames(ratingmat) <- dimension_names
  
  dim(ratingmat)
  
  #create sparse of rating matrix for recommender lab
  
  ratingmat0 <- ratingmat
  ratingmat0[is.na(ratingmat0)] <- 0
  sparse_ratings <- as(ratingmat0, "sparseMatrix")
  rm(ratingmat0)
  gc()
  return(sparse_ratings)
}
getRecommendations <- function(c_user) {
  # Load all the libraries
  loadLibraries()
  current_user <- as.character(c_user)
  
  #get sparse of rating matrix
  sparse_ratings <- getSparseMatrix()
  # already rated
  #alreadyRead <- df_ratings[which(df_ratings$user_id == current_user),2]
  
  real_ratings <- new("realRatingMatrix", data = sparse_ratings)#remove 0's
  
  model <- Recommender(real_ratings, method = "UBCF", param = list(method = "pearson", nn = 4))###why nn 4??
  #Jaccard similarity
  #Cosine similarity
  #Pearson similarity
  
  prediction <- predict(model, real_ratings[current_user, ], type = "ratings")###why type ratings??
  
  recommendation <- as(prediction, 'data.frame') %>% 
    arrange(-rating) %>% .[1:10,] %>% 
    mutate(book_id = as.numeric(as.character(item)))
  # check if already read books is present
  #recommendation <-recommendation[which(!(recommendation$book_id %in% alreayRead)),]
  
  recommended_book_ids <- as.integer(recommendation[,4])
  return(recommended_book_ids)
}

