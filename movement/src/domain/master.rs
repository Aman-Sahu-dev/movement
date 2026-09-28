use std::fmt;

#[derive(Debug, Clone, PartialEq, Eq)]
pub struct MasterTable {
    pub subject_name: String,
    pub subject_code: Option<String>,
    pub expected_classes: Option<u32>,
    pub frequency_per_week: Option<u32>,
}

#[derive(Debug, PartialEq, Eq)]
pub enum MasterTableError {
    MissingName,
}

impl std::error::Error for MasterTableError {}

impl fmt::Display for MasterTableError {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        match self {
            MasterTableError::MissingName => write!(f, "Subject name cannot be empty"),
        }
    }
}

pub struct MasterTableBuilder {
    pub subject_name: Option<String>,
    pub subject_code: Option<String>,
    pub expected_classes: Option<u32>,
    pub frequency_per_week: Option<u32>,
}

impl Default for MasterTableBuilder {
    fn default() -> Self {
        Self::new()
    }
}

impl MasterTableBuilder {
    pub fn new() -> Self {
        Self {
            subject_name: None,
            subject_code: None,
            expected_classes: None,
            frequency_per_week: None,
        }
    }

    pub fn with_name(mut self, name: impl Into<String>) -> Self {
        self.subject_name = Some(name.into());
        self
    }

    pub fn with_code(mut self, code: impl Into<String>) -> Self {
        self.subject_code = Some(code.into());
        self
    }

    pub fn with_classes(mut self, classes: u32) -> Self {
        self.expected_classes = Some(classes);
        self
    }

    pub fn with_freq(mut self, freq: u32) -> Self {
        self.frequency_per_week = Some(freq);
        self
    }

    pub fn build(self) -> Result<MasterTable, MasterTableError> {
        let name = match self.subject_name {
            Some(n) if !n.trim().is_empty() => n.trim().to_string(),
            _ => return Err(MasterTableError::MissingName),
        };

        Ok(MasterTable {
            subject_name: name,
            subject_code: self
                .subject_code
                .map(|c| c.trim().to_string())
                .filter(|c| !c.is_empty()),
            expected_classes: self.expected_classes,
            frequency_per_week: self.frequency_per_week,
        })
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_valid_minimal() {
        let res = MasterTableBuilder::new()
            .with_name("Operating Systems")
            .build();
        assert!(res.is_ok());
        let table = res.unwrap();
        assert_eq!(table.subject_name, "Operating Systems");
        assert_eq!(table.subject_code, None);
    }

    #[test]
    fn test_valid_all_fields() {
        let res = MasterTableBuilder::new()
            .with_name("Data Structures")
            .with_code("CS201")
            .with_classes(40)
            .with_freq(3)
            .build();
        assert!(res.is_ok());
        let table = res.unwrap();
        assert_eq!(table.subject_code.as_deref(), Some("CS201"));
        assert_eq!(table.expected_classes, Some(40));
        assert_eq!(table.frequency_per_week, Some(3));
    }

    #[test]
    fn test_missing_name_fails() {
        let res = MasterTableBuilder::new().build();
        assert_eq!(res, Err(MasterTableError::MissingName));

        let res_whitespace = MasterTableBuilder::new().with_name("   ").build();
        assert_eq!(res_whitespace, Err(MasterTableError::MissingName));
    }
}
